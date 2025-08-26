# AP-Java Summer Work

## Data
Name of Original Dataset: "Superbowl History 1967 - 2020"
Original Dataset Author: Timo Bozsolik
Link: https://www.kaggle.com/datasets/timoboz/superbowl-history-1967-2020
IMPORTANT NOTE: The dataset used in the context of the rest of the README and the actual Java work itself is not the original, but an updated version of it. For this project, at least two numerical, continuous properties were needed, and in the original dataset, the only two numbers included were the winner and loser points, which are integers and therefore not continuous. I thus did some self research and updated two things: the Super Bowls used in the data (previously, it was all from 1967-2020, but now, it's from 2014-2023, so I had to add three) and the numbers, which are now the average rushing yards of each team in each super bowl, as these numbers are not integers/are continuous.

## Usage Rights
This set of original data is publically available for download on the website Kaggle, and is therefore applicable for fair and legal usage on this summer project.

## Analyzing the CSV
Each entry within this dataset represents a Super Bowl that took place anytime from 2014-2023. The coloumns and appropriate Java fields and syntax are as follows:
| Coloumn | Type of Data | Context | Field in Java | Type of Data in Java |
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
│ + SuperBowl()                       │
│ + SuperBowl(parameters)             │
│ + getDate(): String                 │
│ + getTitle(): String                │
│ + getWinner(): String               │
│ + getWinAVG(): double               │
│ + getLoser(): String                │
│ + getLoserAVG(): double             │
│ + setDate(): void                   │
│ + setTitle(): void                  │
│ + setWinner(): void                 │
│ + setWinAVG(): void                 │
│ + setLoser(): void                  │
│ + setLoserAVG(): void               │
│ + findAVGOfGame(): double           │
│ + compareTeams(): String            │
└─────────────────────────────────────┘
```
