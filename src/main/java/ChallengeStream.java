/* (C)2024 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import mocks.CallCostObject;
import mocks.CallSummary;
import mocks.CardWinner;
import mocks.TotalSummary;

public class ChallengeStream {

    /**
     * One stack containing five numbered cards from 0-9 are given to both players. Calculate which hand has winning number.
     * The winning number is calculated by which hard produces the highest two-digit number.
     *
     * calculateWinningHand([2, 5, 2, 6, 9], [3, 7, 3, 1, 2]) ➞ true
     *  P1 can make the number 96
     *  P2 can make the number 73
     *  P1 win the round since 96 > 73
     *
     * The function must return which player hand is the winner and the two-digit number produced. The solution must contain streams.
     *
     * @param player1  hand, player2 hand
     */
    public CardWinner calculateWinningHand(List<Integer> player1, List<Integer> player2) {
        // YOUR CODE HERE...
        CardWinner cardWinner = new CardWinner();


        //Stream way of solving it (Right way according to the instructions XD)
        Integer p1WinningHand = Integer.parseInt(player1.stream().sorted(Comparator.reverseOrder()).limit(2).map(String::valueOf).collect(Collectors.joining()));
        Integer p2WinningHand = Integer.parseInt(player2.stream().sorted(Comparator.reverseOrder()).limit(2).map(String::valueOf).collect(Collectors.joining()));

        if( p1WinningHand >p2WinningHand)
        return new CardWinner("P1",p1WinningHand);
        else if( p2WinningHand > p1WinningHand)
            return new CardWinner("P2", p2WinningHand);
        else
            return  new CardWinner("TIE", p1WinningHand);
    }

    //Adapted for lists

    /**
     * Design a solution to calculate what to pay for a set of phone calls. The function must receive an
     * array of objects that will contain the identifier, type and duration attributes. For the type attribute,
     * the only valid values are: National, International and Local
     *
     * The criteria for calculating the cost of each call is as follows:
     *
     * International: first 3 minutes $ 7.56 -> $ 3.03 for each additional minute
     * National: first 3 minutes $ 1.20 -> $ 0.48 per additional minute
     * Local: $ 0.2 per minute.
     *
     * The function must return the total calls, the details of each call (the detail received + the cost of the call)
     * and the total to pay taking into account all calls. The solution must be done only using streams.
     *
     * @param {Call[]} calls - Call's information to be processed
     *
     * @returns {CallsResponse}  - Processed information
     */
    public TotalSummary calculateCost(List<CallCostObject> costObjectList) {
        List<CallSummary> summaries = costObjectList.stream()
                .filter(c -> "National".equals(c.getType()) || "International".equals(c.getType()) || "Local".equals(c.getType()))
                .map(c -> {
                    double cost = 0.00;
                    //Previous way of thinking I had was that if the call was less than 3 minutes then it must have
                    //cost 7.56 or 1.20, then I realize that it was still a cost per minute XD
                    if ("International".equals(c.getType())) {
                        cost = (c.getDuration() <= 3 ? c.getDuration() * 7.56 : (3 * 7.56) + ((c.getDuration() - 3) * 3.03));
                    } else if ("National".equals(c.getType())) {
                        cost = (c.getDuration() <= 3 ? c.getDuration() * 1.20 : (3 * 1.20) + ((c.getDuration() - 3) * 0.48));
                    } else if ("Local".equals(c.getType())) {
                        cost = c.getDuration() * 0.2;
                    }
                    System.out.println("cost of: " + c.getType() + " " + c.getDuration() + " " + cost);
                    return new CallSummary(c, cost);
                })
                .toList();

        double totalSumCost = summaries.stream().mapToDouble(CallSummary::getTotalCost).sum();
        System.out.println("Total sum cost: " + totalSumCost);

        return new TotalSummary(summaries, summaries.size(), totalSumCost);
    }
}
