;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2525)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2525Code 0
	pts2525 1
)

(local
	[theSel_87 8] = [0 0 5 0 5 5 0 5]
)
(instance poly2525Code of Code
	(properties
		sel_20 {poly2525Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2525a sel_110: sel_117:))
	)
)

(instance poly2525a of Polygon
	(properties
		sel_20 {poly2525a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87)
	)
)

(instance pts2525 of MuseumPoints
	(properties
		sel_20 {pts2525}
	)
)
