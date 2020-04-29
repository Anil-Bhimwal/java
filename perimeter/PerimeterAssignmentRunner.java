import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
        for(Point currPt : s.getPoints()){
            count++;
        }
        
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int num_of_points = getNumPoints(s);
        double perimeter= getPerimeter(s);
        int sides=1;
        if(num_of_points > 2){
            sides = num_of_points;
        }else{
            sides= num_of_points-1;
        }
        double avg = perimeter/((float)sides);
        
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest= -100;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            
            if(currDist> largest){
                largest= currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        
        double largest= -100000;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currX = currPt.getX();
           
            if(currX> largest){
                largest= currX;
            }
        
        }
        return largest;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        double avg_length= getAverageLength(s);
        System.out.println("Average length of sides = " + avg_length);
        int number_of_points=getNumPoints(s);
        System.out.println("number_of_points = " +number_of_points);
        double largest_side= getLargestSide (s);
        System.out.println("Largest side = " + largest_side);
        double largest_x = getLargestX(s);
        System.out.println("Largest X  = " + largest_x);
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
