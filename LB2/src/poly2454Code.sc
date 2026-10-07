;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2454)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2454Code 0
	pts2454 1
)

(local
	[theSel_87 30] = [0 0 319 0 319 123 266 123 272 128 165 129 159 125 104 127 62 135 27 145 7 158 7 183 319 183 319 189 0 189]
)
(instance poly2454Code of Code
	(properties
		sel_20 {poly2454Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2454a sel_110: sel_117:))
	)
)

(instance poly2454a of Polygon
	(properties
		sel_20 {poly2454a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 15)
		(= sel_87 @theSel_87)
	)
)

(instance pts2454 of MuseumPoints
	(properties
		sel_20 {pts2454}
		sel_621 180
		sel_622 155
		sel_627 330
		sel_628 155
	)
)
