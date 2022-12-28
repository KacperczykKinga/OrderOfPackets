# OrderOfPackets
Advent of code - day 13

Solution for riddle from Advent Of Code 2022: https://adventofcode.com/2022/day/13

Text of riddle made by Eric Wastl (without examples):

You climb the hill and again try contacting the Elves. However, you instead receive a signal you weren't expecting: a distress signal.
Your handheld device must still not be working properly; the packets from the distress signal got decoded out of order. You'll need to re-order the list of received packets (your puzzle input) to decode the message.
Your list consists of pairs of packets; pairs are separated by a blank line. You need to identify how many pairs of packets are in the right order. [...]
Packet data consists of lists and integers. Each list starts with [, ends with ], and contains zero or more comma-separated values (either integers or other lists). Each packet is always a list and appears on its own line.
When comparing two values, the first value is called left and the second value is called right. Then:

--If both values are integers, the lower integer should come first. If the left integer is lower than the right integer, the inputs are in the right order. If the left integer is higher than the right integer, the inputs are not in the right order. Otherwise, the inputs are the same integer; continue checking the next part of the input.

--If both values are lists, compare the first value of each list, then the second value, and so on. If the left list runs out of items first, the inputs are in the right order. If the right list runs out of items first, the inputs are not in the right order. If the lists are the same length and no comparison makes a decision about the order, continue checking the next part of the input.

--If exactly one value is an integer, convert the integer to a list which contains that integer as its only value, then retry the comparison. For example, if comparing [0,0,0] and 2, convert the right value to [2] (a list containing 2); the result is then found by instead comparing [0,0,0] and [2]. [...]
Determine which pairs of packets are already in the right order. What is the sum of the indices of those pairs?

Now, you just need to put all of the packets in the right order. Disregard the blank lines in your list of received packets.
The distress signal protocol also requires that you include two additional divider packets:
[[2]]
[[6]]
Using the same rules as before, organize all packets - the ones in your list of received packets as well as the two divider packets - into the correct order. [...]
Afterward, locate the divider packets. To find the decoder key for this distress signal, you need to determine the indices of the two divider packets and multiply them together. (The first packet is at index 1, the second packet is at index 2, and so on.) [...]
Organize all of the packets into the correct order. What is the decoder key for the distress signal?
