# AP-Java Summer Work

## Data
Name of Original Dataset: "Superbowl History 1967 - 2020"
Original Dataset Author: Timo Bozsolik
Link: https://www.kaggle.com/datasets/timoboz/superbowl-history-1967-2020
IMPORTANT NOTE: The dataset used in the context of the rest of the README and the actual Java work itself is not the original, but an updated version of it. For this project, at least two numerical, continuous properties were needed, and in the original dataset, the only two numbers included were the winner and loser points, which are integers and therefore not continuous. I thus did some self research and updated two things: the Super Bowls used in the data (previously, it was all from 1967-2020, but now, it's from 2014-2023, so I had to add three) and the numbers, which are now the average rushing yards of each team in each super bowl, as these numbers are not integers/are continuous.

## Usage Rights
This set of original data is publically available for download on the website Kaggle, and is therefore applicable for fair and legal usage on this summer project.

## Analyzing the CSV
Each entry within this dataset represents a Super Bowl that took place anytime from 2014-2023. The columns and appropriate Java fields and syntax are as follows:
| Column | Type of Data | Context | Field in Java | Type of Data in Java |
|-|-|-|-|-|
| `Date` | Ordinal | The date on which the Super Bowl occured | 'date' | 'String' |
| `SB` | Ordinal | The Roman numeral title of the Super Bowl | 'title' | 'String' |
| `Winner` | Categorical | The name of the winning team | 'winner' | 'String' |
| `Winner Avg R Yds` | Numerical | The average rushing yards of the winning team | 'winAVG' | 'double' |
| `Loser` | Categorical | The name of the losing team | 'loser' | 'String' |
| `Loser Avg R Yds` | Numerical | The average rushing yards of the winning team | 'loseAVG' | 'double' |

### UML Diagram
```
┌─────────────────────────────────────┐
│              SuperBowl              │
├─────────────────────────────────────┤
│ - date: String                      │
│ - title: String                     │
│ - winner: String                    │
│ - winAVG: double                    │
│ - loser: String                     │
│ - loseAVG: double                   │
├─────────────────────────────────────┤
│ + SuperBowl(parameters)             │
│ + findAVGOfGame(): double           │
│ + compareTeams(): String            │
└─────────────────────────────────────┘
```

## Analysis
Analysis #1: Column 4; 'winnerAVG' -- Average value: 5.62 -- Minimum value: 3.5 -- Maximum value: 7.6 (out of 10 entries).
The average value here for the average rushing yards per game in these past ten or so Super Bowls is quite interesting, as the average rushing yards per game over the last ten seasons or so falls at around 4.25, while this is around 5.62. It really showcases how much better the teams that make it to the Super Bowl are, as they are able to rush for around 33% more yards than an average team could in that same season.

Analysis #2: Column 6; 'loserAVG' -- Average value: 5.92 -- Minimum value: 4.2 -- Maximum value: 8.5 (out of 10 entries)
What really stands out to me here are these rushing values compared to the rushing values of the 'winnerAVG' explored previously: they are all larger numbers, which is weird considering these are the stats for the losing team. What I can determine from this is that football as a whole in the NFl has shifted to favor pass concepts rather than running the ball, as it seems as though from these statistics is that teams that run the ball more lose, and the only other thing you can do with the football is pass it.
