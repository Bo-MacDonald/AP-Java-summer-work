public class SuperBowl {
  private String date;
  private String title;
  private String winner;
  private double winnerAVG;
  private String loser;
  private double loserAVG;

  public SuperBowl(String date, String title, String winner, double winnerAVG, String loser, double loserAVG) {
    this.date = date;
    this.title = title;
    this.winner = winner;
    this.winnerAVG = winnerAVG;
    this.loser = loser;
    this.loserAVG = loserAVG;
  }

  public double findAVGOfGame() {
    return (winnerAVG + loserAVG)/2.0;
  }

  public void compareTeams() {
    double difference = ((int)(Math.abs(winnerAVG - loserAVG) * 100.0))/100.0;
    if (winnerAVG >= loserAVG) System.out.println("The " + winner + " beat the " + loser + " in SuperBowl " + title + " on " + date + " and had a better average rushing yards stat by " + difference + " yards per play.");
    if (winnerAVG < loserAVG) System.out.println("Despite the fact that the " + winner + " won SuperBowl " + title + " on " + date + ", the " + loser + " still had a better average rushing yards stat by " + difference + " yards per play.");
  }
}
