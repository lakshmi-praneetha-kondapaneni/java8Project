package comparatorAndComparable;//A Java program to demonstrate Comparator interface
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;



// A class 'Movie' that implements Comparable
class Movie implements Comparable<Movie>
{
    private double rating;
    private String name;
    private int year;

    // Used to sort movies by year


    // Constructor
    public Movie(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data
    public double getRating() { return rating; }
    public String getName() { return name; }
    public int getYear()	 { return year; }


    @Override
    public int compareTo(Movie o) {

        int k=this.year - o.getYear();
        if(k==0)
            return this.name.compareTo(o.getName());
    return k;
    }
}

// Class to compare Movies by ratings
class RatingCompare implements Comparator<Movie>
{
    public int compare(Movie m1, Movie m2)
    {
        if (m1.getRating() < m2.getRating()) return -1;
        if (m1.getRating() > m2.getRating()) return 1;
        else return 0;
    }
}

// Class to compare Movies by name
class NameCompare implements Comparator<Movie>
{
    public int compare(Movie m1, Movie m2)
    {
        int k=m1.getName().compareTo(m2.getName());
        return k;
    }
}

// Driver class
class Main
{
    public static void main(String[] args)
    {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Empire Strikes Back", 8.0, 1988));
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.3, 1955));
        list.add(new Movie("Star Wars", 8.5, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        list.add(new Movie("Return of the Jedi", 8.4, 1953));

        // Sort by rating : (1) Create an object of ratingCompare
        //				 (2) Call Collections.sort
        //				 (3) Print Sorted list
   /*     System.out.println("Sorted by rating");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        for (Movie movie: list)
            System.out.println(movie.getRating() + " " +
                    movie.getName() + " " +
                    movie.getYear());

*/
        // Call overloaded sort method with RatingCompare
        // (Same three steps as above)
        System.out.println("\nSorted by name");
        NameCompare nameCompare = new NameCompare();
        Collections.sort(list, nameCompare);
        for (Movie movie: list)
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());

        // Uses Comparable to sort by year and name
        System.out.println("\nSorted by year and name");
        Collections.sort(list);
        for (Movie movie: list)
            System.out.println(movie.getYear() + " " +
                    movie.getRating() + " " +
                    movie.getName()+" ");
        var sortedList = list.stream()
                // sort it (does not sort the original list)...
                .sorted(Comparator.comparing(Movie::getName)
                        .thenComparing(Movie::getRating)).collect(Collectors.toList());
        System.out.println("Sort by name and then rating");
        list.forEach(x->System.out.println(x.getName()+" "+x.getRating()+" "+x.getYear()));
        Collections.sort(list, new Comparator() {

            public int compare(Object o1, Object o2) {

                String x1 = ((Movie) o1).getName();
                String x2 = ((Movie) o2).getName();
                int sComp = x2.compareTo(x1);

                if (sComp != 0) {
                    return sComp;
                }

                Integer x11 = ((Movie) o1).getYear();
                Integer x12 = ((Movie) o2).getYear();
                return x12.compareTo(x11);
            }});
        System.out.println("sort by name and by year");
        for (Movie movie: list)
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        System.out.println("Sort by rating and year using streams");
        var sortedList1 = list.stream()
                .sorted(Comparator.comparing(Movie::getRating)
                        .thenComparing(Movie::getYear)).collect(Collectors.toList());
        for(Movie movie:sortedList1)
        {
            System.out.println(movie.getRating()+" "+movie.getYear()+" "+
                    movie.getName());
        }
        var sortedArray = list.stream()
                .sorted(Comparator.comparing(Movie::getRating,
                                (rating1,rating2)->Double.compare(rating2,rating1))
                        .thenComparing(Movie::getYear,
                                (year1,year2)->year2-year1))
                        .toArray(Movie[]::new);
        System.out.println("sorted array");
        for(Movie m: sortedArray)
        {
            System.out.println(m.getRating()+" "+m.getYear()+" "+m.getName());
        }

    }
}
