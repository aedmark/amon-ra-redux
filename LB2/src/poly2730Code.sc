;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2730)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2730Code 0
	pts2730 1
)

(local
	[theSel_87 10] = [0 189 0 0 319 0 319 22 38 189]
	[theSel_87_2 6] = [51 189 319 30 319 189]
)
(instance poly2730Code of Code
	(properties
		sel_20 {poly2730Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2730a sel_110: sel_117:) (poly2730b sel_110: sel_117:)
		)
	)
)

(instance poly2730a of Polygon
	(properties
		sel_20 {poly2730a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 5)
		(= sel_87 @theSel_87)
	)
)

(instance poly2730b of Polygon
	(properties
		sel_20 {poly2730b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 3)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2730 of MuseumPoints
	(properties
		sel_20 {pts2730}
		sel_621 200
		sel_622 164
		sel_623 298
		sel_624 140
		sel_627 319
		sel_628 189
		sel_630 153
	)
)
