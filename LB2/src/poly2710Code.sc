;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2710)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2710Code 0
	pts2710 1
)

(local
	[theSel_87 40] = [0 189 0 0 319 0 319 159 269 159 258 168 222 168 202 160 142 160 129 168 114 167 91 161 91 142 78 142 59 142 59 155 83 155 81 163 66 172 11 172]
	[theSel_87_2 8] = [100 189 118 179 275 179 299 189]
)
(instance poly2710Code of Code
	(properties
		sel_20 {poly2710Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2710a sel_110: sel_117:) (poly2710b sel_110: sel_117:)
		)
	)
)

(instance poly2710a of Polygon
	(properties
		sel_20 {poly2710a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 20)
		(= sel_87 @theSel_87)
	)
)

(instance poly2710b of Polygon
	(properties
		sel_20 {poly2710b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2710 of MuseumPoints
	(properties
		sel_20 {pts2710}
		sel_621 200
		sel_622 164
		sel_623 298
		sel_624 140
		sel_627 319
		sel_628 189
		sel_630 153
	)
)
