## Answers to Lab Exercise 3 Part 2 - SeiP 2024
Name: Juozapas Rokas Cypas
### Task 1
Fuzz result1: ".a....@..b.3.);. M.....[.R...4.ja.o....v..]h..]..)Y.........E%.9......Us.\.........YBr..D=.3.Y..,.<3.....!...H...............Y]rl..hm,&[W._l..Z?....g........U.=....
"<br />
Fuzz result2: ".a....#........W.......b.3.) ;.M.....[.R.j.!....YBr..D=.3.Y. ..)Yl........E%.9.<3..4m,&[W._l..Z.....Us.\9.j.!....YBr..D=.3.Y..4.<3wwd....s...5..^..@m,&^W._l..Z?....g......<.U.=.&.\
"<br />
Answer: Two consecutive digits (there can be other symbols in between, these others symbols are ignored) cause a crash when the second digit is larger than the first digit by 1, but the second digit can't be the last in the sequence.<br /> Example 1: "hi12h" would cause a crash.<br /> Example 2: "hi12" wouldn't cause a crash because "2" is the last character of the string.
<br /> In fuzz results 1 and 2 there were consecutive digits where the second was larger than the first, with some ignored symbols in between.<br />
Also a null character as the first or last element of the string (char array) would cause a crash, but it's not the case here.
### Task 2
fuzz result1: "Se/t................t<.....f{f....t<../.-A.V.u..`al..ttttt..D?"<br />
fuzz result2: "Se/..Rt<........#..B.3c..Rt<........#..B.3c..<....B))........./.~fflll.fffffff....../.~fflll.fffffff..WW
"<br />
fuzz result3: "al...Qt,..Q.........tttt,))ff).-LO.+l.gZ'A.bj...)ffffffffffff.fffffffffff/W
"<br />
Answer: in result1 a crew member is fired 2 times, then the plane tries to land with 0 crew members(because the program starts with 2 crew members), and that causes the program to abort.<br />
In result2 the reason for crashing is the same as in result1, basically input "tffl" causes the crash<br />
In result3 it's the same, the plane lands, takes off, fires 2 members, then tries to land without a crew

### Task 3

input1: .}|Wr{..O6j..=|....A3.)..b.M.!.4az...;..#...vT../......^D...c5;(-mJ.....E.....|.Unw~Z~..^..7.k.QHn...P.\........>S...w...^sp.!O...L.....73.............n....W/M.....m..5J...oX....@...0......K.P..S....k............6..).}.8.....".....0.Y...d...(..(.y..N...N.4....cT(.^'3.&.:%Pt.B).g.......v..O8=..tTR.s#.....|...Ct.D.D.>.Ij....Y.n..e..=...t.........0#02.....+.j0V....[D..Dx ...V....|.TR.s#.....ffffe'...c.........$.@2...\`9.=."..%2. .....&.......48......lU.+..;J.0..F.GX .......0.^.^........g.ki...:.....t.x.Do...+.....po]AWy.m.. D.`.Q..<@|..O,^.]...g.J.l1..6..$.|M\.EGq<br />

input2: =|Wr{..O6j..=|A3.)..b.M.!.4az...;..#...vT../......^D...c5;(-mJ.....E.....|.UnwZ..^..7.k.QHn...P.........>S...w...^sp.!O...L.....73.............n....W/M.....m..5J...oX....@...0......K.P..S....k............6..).}.8.....".....0.Y...d...(..(.y..N...N.4....cT(.^'3.&.:%Pt.B).g.......v..O8=..tTR.s#.....|...Ct.D.D.>.Ij....Y.n..e..=...t.........0#02.....+.j0V....[D..Dx ...V....|.TR.s#.....ffffe'...c.........$.@2...9.=."..%2. .....&.......48......lU.+..;J.0..F.GX .......0.^.^........g.ki...:.....t.x.Do...+.....po]AWy.m.. D..Q..<@|..O,^.]...g.J.l1..6..$.|M.EGq<br />

input3 .}|Wr{..O6.hhhB).gO6j..=|....A3.)..b.M.!.4az...;..#...vT../......^D...c5;(-mJ.....E.....|.Unw~Z~..^..7.k.QHn...P.\........>S...w...^sp.!O...L.....73.............n....W/M.....m.....@...0......Kf5J...oX....@...0......Kffffff....48......lU.+..;J.0..F....".(..(.y..N...N.4....cT(.^'3.&.:%Pt.B).g.......v..O8=..tTR.s#.....|...Ct.D.D.>.Ij....Y.n..e..=...t.........0#02.....+.j0V....[D..Dx ...V....|.e'...c.........ffffffffffffffffffffffffffff....48......lU.+..;J.0..F.GX.......0.^.^........g.ki...:.....t.x.Do...+.....po]AWy.m.. D.`.Q..<@|..O,^.]...g.<br />

Repeated Sequences: All inputs contain repeated sequences of characters, such as 'hhhh', 'ffffff', etc. These repeated sequences occur at different positions within each input.

Numeric Sequences: Each input contains numeric sequences like '48' and '32'. These numeric sequences are present in different positions within the inputs.

My guess is that the rules about taking off, landing, hiring ,firing are the same, but some variables could be different, like the size of the crew for example.

