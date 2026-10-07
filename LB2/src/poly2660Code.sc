;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2660)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2660Code 0
	pts2660 1
)

(local
	[theSel_87 20] = [123 189 0 189 0 0 319 0 319 189 197 189 195 140 182 114 139 114 123 141]
)
(instance poly2660Code of Code
	(properties
		sel_20 {poly2660Code}
	)
	
	(method (sel_57 param1)
		(param1 sel_118: (poly2660a sel_110: sel_117:))
	)
)

(instance poly2660a of Polygon
	(properties
		sel_20 {poly2660a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 10)
		(= sel_87 @theSel_87)
	)
)

(instance pts2660 of MuseumPoints
	(properties
		sel_20 {pts2660}
		sel_621 200
		sel_622 164
		sel_623 298
		sel_624 140
		sel_627 319
		sel_628 189
		sel_630 153
	)
)
