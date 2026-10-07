;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2490)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2490Code 0
	pts2490 1
)

(local
	[theSel_87 10] = [0 0 319 0 319 138 223 130 0 151]
)
(instance poly2490Code of Code
	(properties
		sel_20 {poly2490Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2490a sel_110: sel_117:))
	)
)

(instance poly2490a of Polygon
	(properties
		sel_20 {poly2490a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 5)
		(= sel_87 @theSel_87)
	)
)

(instance pts2490 of MuseumPoints
	(properties
		sel_20 {pts2490}
		sel_621 125
		sel_622 160
		sel_625 125
		sel_626 250
	)
)
