class Solution {
  public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    int ans = 0;

    Arrays.sort(players);
    Arrays.sort(trainers);

    int i = 0; 
    int j = 0;
    int count = 0;

    while (i < players.length && j < trainers.length) {
      if (players[i] <= trainers[j]) {
        count++; // match found
        i++;
        j++;
      } 
      else j++; // try next trainer
    }

    return count;
  }
}