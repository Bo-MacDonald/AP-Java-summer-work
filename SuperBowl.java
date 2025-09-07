public class SuperBowl {
  
  //fields for the SuperBowl object
  private String date;
  private String title;
  private String winner;
  private double winAVG;
  private String loser;
  private double loseAVG;

  //constructor method
  public SuperBowl(String date, String title, String winner, double winAVG, String loser, double loseAVG) {
    this.date = date;
    this.title = title;
    this.winner = winner;
    this.winAVG = winAVG;
    this.loser = loser;
    this.loseAVG = loseAVG;
  }
  
  //method to find the average rushing yards of the entire game
  public double findAVGOfGame() {
    return (winAVG + loseAVG)/2.0;
  }

  //method that compares the two teams and their stats
  public void compareTeams() {
    double difference = ((int)(Math.abs(winAVG - loseAVG) * 100.0))/100.0;
    if (winAVG >= loseAVG) System.out.println("The " + winner + " beat the " + loser + " in SuperBowl " + title + " on " + date + " and had a better average rushing yards stat by " + difference + " yards per play.");
    if (winAVG < loseAVG) System.out.println("Despite the fact that the " + winner + " won SuperBowl " + title + " on " + date + ", the " + loser + " still had a better average rushing yards stat by " + difference + " yards per play.");
  }

  //toString methid
  public String toString() {
        return "\nHere are the stats for your requested superbowl -> Date: " + date + " of SuperBowl " + title + "; Winner: " + winner + " with " + winAVG + " avg. rushing yards; Loser: " + loser + " with " + loseAVG + " avg. rushing yards\n"; 
    }
}
