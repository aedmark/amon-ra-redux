;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2520)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2520Code 0
	pts2520 1
)

(local
	[theSel_87 32] = [68 102 21 145 123 177 123 189 0 189 0 0 319 0 319 189 232 189 232 177 308 177 277 149 214 149 214 118 224 112 212 102]
	[theSel_87_2 8] = [77 107 203 107 203 126 77 126]
)
(instance poly2520Code of Code
	(properties
		sel_20 {poly2520Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2520a sel_110: sel_117:) (poly2520b sel_110: sel_117:)
		)
	)
)

(instance poly2520a of Polygon
	(properties
		sel_20 {poly2520a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 16)
		(= sel_87 @theSel_87)
	)
)

(instance poly2520b of Polygon
	(properties
		sel_20 {poly2520b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2520 of MuseumPoints
	(properties
		sel_20 {pts2520}
		sel_621 130
		sel_622 145
		sel_625 165
		sel_626 250
	)
)
