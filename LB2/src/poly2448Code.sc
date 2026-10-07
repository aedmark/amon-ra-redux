;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2448)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2448Code 0
	pts2448 1
)

(local
	[theSel_87 36] = [80 189 0 189 0 0 319 0 319 189 222 189 222 141 195 138 195 131 185 129 168 115 146 79 135 115 125 123 74 123 72 126 113 126 80 141]
)
(instance poly2448Code of Code
	(properties
		sel_20 {poly2448Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2448a sel_110: sel_117:))
	)
)

(instance poly2448a of Polygon
	(properties
		sel_20 {poly2448a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 18)
		(= sel_87 @theSel_87)
	)
)

(instance pts2448 of MuseumPoints
	(properties
		sel_20 {pts2448}
		sel_621 170
		sel_622 130
		sel_623 145
		sel_624 105
		sel_625 170
		sel_626 220
	)
)
