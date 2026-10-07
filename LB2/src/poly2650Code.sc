;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2650)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2650Code 0
	pts2650 1
)

(local
	[theSel_87 22] = [0 0 319 0 319 138 179 101 61 115 59 111 49 111 42 122 58 122 56 189 0 189]
	[theSel_87_2 10] = [96 155 78 120 170 109 208 132 99 159]
	[theSel_87_3 16] = [208 184 192 170 222 157 229 163 244 161 237 168 244 176 215 188]
	[theSel_87_4 8] = [171 146 182 155 164 163 155 154]
)
(instance poly2650Code of Code
	(properties
		sel_20 {poly2650Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2650a sel_110: sel_117:)
				(poly2650b sel_110: sel_117:)
				(poly2650c sel_110: sel_117:)
				(poly2650d sel_110: sel_117:)
		)
	)
)

(instance poly2650a of Polygon
	(properties
		sel_20 {poly2650a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 11)
		(= sel_87 @theSel_87)
	)
)

(instance poly2650b of Polygon
	(properties
		sel_20 {poly2650b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 5)
		(= sel_87 @theSel_87_2)
	)
)

(instance poly2650c of Polygon
	(properties
		sel_20 {poly2650c}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 8)
		(= sel_87 @theSel_87_3)
	)
)

(instance poly2650d of Polygon
	(properties
		sel_20 {poly2650d}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_4)
	)
)

(instance pts2650 of MuseumPoints
	(properties
		sel_20 {pts2650}
		sel_621 125
		sel_622 165
		sel_625 125
		sel_626 250
	)
)
