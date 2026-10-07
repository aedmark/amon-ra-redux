;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2456)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2456Code 0
	pts2456 1
)

(local
	[theSel_87 8] = [0 0 5 0 5 5 0 5]
)
(instance poly2456Code of Code
	(properties
		sel_20 {poly2456Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2456a sel_110: sel_117:))
	)
)

(instance poly2456a of Polygon
	(properties
		sel_20 {poly2456a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87)
	)
)

(instance pts2456 of MuseumPoints
	(properties
		sel_20 {pts2456}
	)
)
