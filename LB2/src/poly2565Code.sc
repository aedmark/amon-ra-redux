;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2565)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2565Code 0
	pts2565 1
)

(local
	[theSel_87 20] = [3 131 3 185 314 184 310 158 280 148 258 147 172 129 91 139 50 150 14 152]
)
(instance poly2565Code of Code
	(properties
		sel_20 {poly2565Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2565a sel_110: sel_117:))
	)
)

(instance poly2565a of Polygon
	(properties
		sel_20 {poly2565a}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 10)
		(= sel_87 @theSel_87)
	)
)

(instance pts2565 of MuseumPoints
	(properties
		sel_20 {pts2565}
	)
)
