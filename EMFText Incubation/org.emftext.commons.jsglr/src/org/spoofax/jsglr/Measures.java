package org.spoofax.jsglr;

/**
 * 
 * @author Emma Nilsson-Nyman <emma at cs.lth.se>
 *
 */
public class Measures {
    
    // Time

    private long time;
    
    public void setTime(long t) {
        time = t;
    }
    
    public long getTime() {
        return time;
    }

    // Parse time
    
    private long parseTime;
    
    public void setParseTime(long time) {
        parseTime = time;
    }
    
    public long getParseTime() {
        return parseTime;
    }

    // Average parse time
    
    private int averageParseTime;
    
    public void setAverageParseTime(int time) {
        averageParseTime = time;
    }
    
    public int getAverageParseTime() {
        return averageParseTime;
    }
    
    // Parse count
    
    private static int parseCount;
    
    public static void setParseCount(int count) {
        parseCount = count;
    }
    
    public static int getParseCount() {
        return parseCount;
    }

    // Reduction count

    private int reductionCount;
    
    public void setReductionCount(int count) {
        reductionCount = count;
    }
    
    public int getReductionCount() {
           return reductionCount;
    }

    // Avoid count

    private int avoidCount;
    
    public void setAvoidCount(int count) {
        avoidCount = count;
    }
    
    public int getAvoidCount() {
        return avoidCount;
    }
    
    // Frames created
    
    private int framesCreated;
    
    public void setFramesCreated(int frames) {
        framesCreated = frames;
    }
  
    public int getFramesCreated() {
        return framesCreated;
    }

    // Links created
    
    private int linksCreated;
    
    public void setLinkedCreated(int links) {
        linksCreated = links;
    }
    
    public int getLinksCreated() {
        return linksCreated;
    }

    // Recover time
    
    private long recoverTime;
    
    public void setRecoverTime(long time) {
        recoverTime = time;
    }
    
    public long getRecoverTime() {
        return recoverTime;
    }

    
    
    public String toString() {
        String res = "Time: " + time + " ms, " +
            "Total parse time: " + parseTime + " ms, " +
            "Avg parse time: " + averageParseTime + ", " +
            "Recover time: " + recoverTime + ", " +
            "Parse count: " + parseCount + ", " +
            "Red. count: " + reductionCount + "," + 
            "Avoid count: " + avoidCount + ", " +
            "Frames created: " + framesCreated + ", " +
            "Links created: " + linksCreated;
        return res;
    }

    public DiffMeasure diff(Measures m) {
        return new DiffMeasure(this, m);
    }

    
    public class DiffMeasure {
        private Measures base;
        private Measures m;
        
        private int proTime;
        private int proParseTime;
        private int proRecoverTime;
        private int proAvgParseTime;
        private int proParseCount;
        private int proRedCount;
        private int proAvoidCount;
        private int proFramesCreated;
        private int proLinksCreated;
        
        private DiffMeasure(Measures b, Measures me) {
            base = b;
            m = me;
            
            // Time
            proTime = (int)Math.round((m.getTime()*1.0/base.getTime())*100);
            proParseTime = (int)Math.round((m.getParseTime()*1.0/base.getParseTime())*100);
            proRecoverTime = (int)Math.round((m.getRecoverTime()*1.0/base.getRecoverTime())*100);
            proAvgParseTime = (int)Math.round((m.getAverageParseTime()*1.0/base.getAverageParseTime())*100);
            
            // Count
            proParseCount = (int)Math.round((m.getParseCount()*1.0/base.getParseCount())*100);
            proRedCount = (int)Math.round((m.getReductionCount()*1.0/base.getReductionCount())*100);
            proAvoidCount = (int)Math.round((m.getAvoidCount()*1.0/base.getAvoidCount())*100);
            
            // Created
            proFramesCreated = (int)Math.round((m.getFramesCreated()*1.0/base.getFramesCreated())*100);
            proLinksCreated = (int)Math.round((m.getLinksCreated()*1.0/base.getLinksCreated())*100);
            
        }
        
        public int getProTime() {
            return proTime;
        }
        public int getProParseTime() {
            return proParseTime;
        }
        public int getProAvgParseTime() {
            return proAvgParseTime;
        }
        public int getProRecoverTime() {
            return proRecoverTime;
        }
        public int getProParseCount() {
            return proParseCount;
        }
        public int getProAvoidCount() {
            return proAvoidCount;
        }
        public int getProRedCount() {
            return proRedCount;
        }
        public int getProFramesCreated() {
            return proFramesCreated;
        }
        public int getProLinksCreated() {
            return proLinksCreated;
        }
        
        public String toString() {
            String res = "Time: " + proTime + "%, " + 
                "Parse time: " + proParseTime + "%, " + 
                "Recover time: " + proRecoverTime + "%, " + 
                "Avg. parse time: " + proAvgParseTime + "%, " + 
                "Parse count: " + proParseCount + "%, " + 
                "Red. count: " + proRedCount + "%, " +
                "Avoid count: " + proAvoidCount + "%, " +
                "Frames created: " + proFramesCreated + "%, " + 
                "Links created: " + proLinksCreated;
            return res;
        }
    }
}
