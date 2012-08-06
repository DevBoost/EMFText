/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.chess;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.chess.resource.cg.CgEProblemSeverity;
import org.emftext.language.chess.resource.cg.CgEProblemType;
import org.emftext.language.chess.resource.cg.ICgOptionProvider;
import org.emftext.language.chess.resource.cg.ICgOptions;
import org.emftext.language.chess.resource.cg.ICgProblem;
import org.emftext.language.chess.resource.cg.ICgQuickFix;
import org.emftext.language.chess.resource.cg.ICgResourcePostProcessor;
import org.emftext.language.chess.resource.cg.ICgResourcePostProcessorProvider;
import org.emftext.language.chess.resource.cg.mopp.CgResource;

/**
 * This is very rough implementation of the rules to move pieces.
 * It is neither complete nor correct, but it shows how the chess
 * model can be analyzed.
 */
public class MoveChecker implements ICgResourcePostProcessor,
	ICgResourcePostProcessorProvider, ICgOptionProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(ICgOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new MoveChecker());
		return options;
	}

	public void process(CgResource resource) {
		CgResource chessResource = resource;
		List<EObject> contents = chessResource.getContents();
		for (EObject next : contents) {
			ChessGame game = (ChessGame) next;
			Board board = game.getBoard();
			Board copy = (Board) EcoreUtil.copy(board);
			EList<Round> rounds = game.getRounds();
			List<Move> moves = new LinkedList<Move>();

			for (Round round : rounds) {
				moves.addAll(round.getMoves());
			}
			analyzeMoves(chessResource, copy, moves);
		}
	}

	private void analyzeMoves(CgResource resource, Board board, List<Move> moves) {
		for (Move move : moves) {
			analyzeMove(resource, board, move);
		}
	}

	private void analyzeMove(CgResource resource, Board board, Move move) {
		int fromColumn = Character.toUpperCase(move.getFromColumn()) - 'A' + 1;
		int fromRow = move.getFromRow();
		int toColumn = Character.toUpperCase(move.getToColumn()) - 'A' + 1;
		int toRow = move.getToRow();

		Square fromSquare = getSquare(board, fromColumn, fromRow);
		if (fromSquare instanceof EmptySquare) {
			resource.addProblem(new ICgProblem() {

				public CgEProblemType getType() {
					return CgEProblemType.ANALYSIS_PROBLEM;
				}

				public String getMessage() {
					return "There is no piece at this location.";
				}

				public Collection<ICgQuickFix> getQuickFixes() {
					return null;
				}

				public CgEProblemSeverity getSeverity() {
					return CgEProblemSeverity.ERROR;
				}
			}, move);
			return;
		}
		checkMove(resource, (NonEmptySquare) fromSquare, move, fromColumn, fromRow, toColumn, toRow);
		movePiece(board, fromSquare, fromColumn, fromRow, toColumn, toRow);
	}

	private void checkMove(CgResource resource, final NonEmptySquare square, Move move, int fromColumn, int fromRow,
			int toColumn, int toRow) {
		// TODO add rules for special moves (Castling, En Passant, Promotion)
		Piece piece = square.getPiece();
		boolean isValidMove = false;

		switch (piece) {
		case BISHOP:
			isValidMove = isValidBishopMove(fromColumn, fromRow, toColumn, toRow);
			break;
		case KING:
			isValidMove = isValidKingMove(fromColumn, fromRow, toColumn, toRow);
			break;
		case KNIGHT:
			isValidMove = isValidKnightMove(fromColumn, fromRow, toColumn, toRow);
			break;
		case PAWN:
			isValidMove = isValidPawnMove(square.getPlayer(), fromColumn, fromRow, toColumn, toRow);
			break;
		case QUEEN:
			isValidMove = isValidQueenMove(fromColumn, fromRow, toColumn, toRow);
			break;
		case ROOK:
			isValidMove = isValidRookMove(fromColumn, fromRow, toColumn, toRow);
			break;
		}

		if (!isValidMove) {
			resource.addProblem(new ICgProblem() {

				public CgEProblemType getType() {
					return CgEProblemType.ANALYSIS_PROBLEM;
				}

				public String getMessage() {
					return "This is not a legal move for a " + square.getPiece().getName() + ".";
				}

				public Collection<ICgQuickFix> getQuickFixes() {
					return null;
				}

				public CgEProblemSeverity getSeverity() {
					return CgEProblemSeverity.ERROR;
				}
			}, move);
		}
	}

	private boolean isValidRookMove(int fromColumn, int fromRow, int toColumn,
			int toRow) {
		return fromColumn == toColumn || fromRow == toRow;
	}

	private boolean isValidQueenMove(int fromColumn, int fromRow, int toColumn,
			int toRow) {
		return isValidBishopMove(fromColumn, fromRow, toColumn, toRow) ||
			isValidRookMove(fromColumn, fromRow, toColumn, toRow);
	}

	private boolean isValidPawnMove(Player player, int fromColumn, int fromRow, int toColumn,
			int toRow) {
		int deltaX = fromColumn - toColumn;
		int deltaY = fromRow - toRow;

		if (player == Player.WHITE) {
			boolean isInitial = fromRow == 2;
			if (isInitial) {
				return (deltaX == 1 && deltaY == -1) || (deltaX == 0 && deltaY >= -2);
			} else {
				return (deltaX == 1 && deltaY == -1) || (deltaX == 0 && deltaY == -1);
			}
		} else {
			boolean isInitial = fromRow == 7;
			if (isInitial) {
				return (deltaX == 1 && deltaY == 1) || (deltaX == 0 && deltaY <= 2);
			} else {
				return (deltaX == 1 && deltaY == 1) || (deltaX == 0 && deltaY == 1);
			}
		}
	}

	private boolean isValidKnightMove(int fromColumn, int fromRow,
			int toColumn, int toRow) {
		int deltaX = Math.abs(fromColumn - toColumn);
		int deltaY = Math.abs(fromRow - toRow);
		int deltaSum = deltaX + deltaY;
		return deltaSum == 3;
	}

	private boolean isValidKingMove(int fromColumn, int fromRow, int toColumn,
			int toRow) {
		int deltaX = Math.abs(fromColumn - toColumn);
		int deltaY = Math.abs(fromRow - toRow);
		return deltaX <= 1 && deltaY <= 1;
	}

	private boolean isValidBishopMove(int fromColumn, int fromRow,
			int toColumn, int toRow) {
		int deltaX = Math.abs(fromColumn - toColumn);
		int deltaY = Math.abs(fromRow - toRow);
		return deltaX == deltaY;
	}

	private void movePiece(Board board, Square fromSquare, int fromColumnIdx, int fromRowIdx, int toColumnIdx, int toRowIdx) {
		Row fromRow = board.getRows().get(8 - fromRowIdx);
		fromRow.getSquares().set(fromColumnIdx - 1, ChessFactory.eINSTANCE.createEmptySquare());

		Row toRow = board.getRows().get(8 - toRowIdx);
		toRow.getSquares().set(toColumnIdx - 1, fromSquare);
	}

	private Square getSquare(Board board, int column, int rowIndex) {
		Row row = board.getRows().get(8 - rowIndex);
		Square square = row.getSquares().get(column - 1);
		return square;
	}

	public ICgResourcePostProcessor getResourcePostProcessor() {
		return new MoveChecker();
	}

	public void terminate() {
		// do nothing
	}
}
