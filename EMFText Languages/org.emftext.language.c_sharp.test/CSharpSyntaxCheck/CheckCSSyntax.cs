using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.CodeDom;
using System.CodeDom.Compiler;
using Microsoft.CSharp;
using System.IO;
using System.Collections;

namespace CodeCheck
{
    class SyntaxCheck
    {        
        private static CompilerParameters cp;
        private static CSharpCodeProvider compiler;
        private static int failureCount = 0;

       //returns the number of failures as exit code
        static void Main(string[] args)
        {
            init();
            //if there's no input then the exit value will be -1
            if (args.Length == 0)
            {
                failureCount = -1;  
                Console.WriteLine("Too few command line arguments.");
            }
            else
            {
                foreach (var name in args)
                {
                    fileOrDirectory(name);
                }
            }
            Environment.ExitCode = failureCount;
        }

        private static void init()
        {
            cp = new CompilerParameters();
            var options = new System.Collections.Generic.Dictionary<string, string>();
            options.Add("CompilerVersion", "v3.5");

            //adds all standard .net 3.5 namespaces
            cp.ReferencedAssemblies.Add("System.Core.dll");
            cp.ReferencedAssemblies.Add("System.dll");
            cp.ReferencedAssemblies.Add("mscorlib.dll");
            cp.ReferencedAssemblies.Add("System.Xml.dll");    
            cp.ReferencedAssemblies.Add("System.Data.dll");
            cp.ReferencedAssemblies.Add("System.Web.dll");
            cp.ReferencedAssemblies.Add("System.Drawing.dll");
            cp.ReferencedAssemblies.Add("System.Windows.Forms.dll");
            cp.ReferencedAssemblies.Add("System.ServiceModel.dll");
            cp.ReferencedAssemblies.Add("System.Workflow.ComponentModel.dll");
            cp.ReferencedAssemblies.Add("System.Workflow.Runtime.dll");
            cp.ReferencedAssemblies.Add("System.Workflow.Activities.dll");
            cp.ReferencedAssemblies.Add("WindowsBase.dll");
            cp.ReferencedAssemblies.Add("PresentationCore.dll");
            cp.ReferencedAssemblies.Add("PresentationFramework.dll");
            cp.CompilerOptions += " /unsafe ";


            compiler = new CSharpCodeProvider(options);
        }

        //determines wheter a given string is a directory or a file
        private static void fileOrDirectory(string name)
        {
            try
            {
                FileSystemInfo fsi = new FileInfo(name);
                if (fsi.Attributes == FileAttributes.Directory)
                {
                    //is a directory
                    DirectoryInfo di = new DirectoryInfo(name);
                    FileInfo[] csfiles = di.GetFiles("*.csharp");
                    Console.WriteLine("Checking {0} file(s) in "+name, csfiles.Length);
                    foreach (var file in csfiles)
                    {
                        check(new string[] { file.FullName });
                    }
                }
                else
                {
                    FileInfo fi = new FileInfo(name);

                    if (fi.Exists)
                    {
                        // is a file
                        check(new string[] { name });
                    }
                    else
                    {
                        Console.WriteLine("{0} does not exist", name);
                        failureCount = -1;
                    }
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                failureCount = -1;
            }
            
            
        }

        //checks programmatically if the given files are syntactically correct
        private static void check(string[] filenames)
        {
            try
            {
                CompilerResults cr = compiler.CompileAssemblyFromFile(cp, filenames);
                if (cr.Errors.HasErrors)
                {
                    failureCount++;
                    foreach (CompilerError err in cr.Errors)
                    {          
                        Console.Error.WriteLine(err.FileName+" : "+err.ErrorText);
                    }
                }

            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
         
        }
    }
}
