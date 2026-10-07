;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2620)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2620Code 0
	pts2620 1
)

(local
	[theSel_87 8] = [0 0 5 0 5 5 0 5]
)
(instance poly2620Code of Code
	(properties
		sel_20 {poly2620Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2620a sel_110: sel_117:))
	)
)

(instance poly2620a of Polygon
	(properties
		sel_20 {poly2620a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87)
	)
)

(instance pts2620 of MuseumPoints
	(properties
		sel_20 {pts2620}
	)
)
