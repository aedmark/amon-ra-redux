;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2715)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2715Code 0
	pts2715 1
)

(local
	[theSel_87 14] = [168 170 217 170 217 167 161 167 203 152 152 152 30 170]
	[theSel_87_2 8] = [93 167 123 162 169 162 148 167]
)
(instance poly2715Code of Code
	(properties
		sel_20 {poly2715Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2715a sel_110: sel_117:) (poly2715b sel_110: sel_117:)
		)
	)
)

(instance poly2715a of Polygon
	(properties
		sel_20 {poly2715a}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 7)
		(= sel_87 @theSel_87)
	)
)

(instance poly2715b of Polygon
	(properties
		sel_20 {poly2715b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2715 of MuseumPoints
	(properties
		sel_20 {pts2715}
		sel_621 200
		sel_622 164
		sel_623 298
		sel_624 140
		sel_627 319
		sel_628 189
		sel_630 153
	)
)
