;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2510)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2510Code 0
	pts2510 1
)

(local
	[theSel_87 46] = [45 162 4 169 4 189 0 189 0 0 319 0 319 189 313 189 313 133 309 133 309 168 284 168 252 161 256 154 286 154 286 139 207 151 89 151 84 148 40 148 5 137 5 153 36 153]
	[theSel_87_2 8] = [125 175 188 175 188 183 125 183]
)
(instance poly2510Code of Code
	(properties
		sel_20 {poly2510Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2510a sel_110: sel_117:) (poly2510b sel_110: sel_117:)
		)
	)
)

(instance poly2510a of Polygon
	(properties
		sel_20 {poly2510a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 23)
		(= sel_87 @theSel_87)
	)
)

(instance poly2510b of Polygon
	(properties
		sel_20 {poly2510b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2510 of MuseumPoints
	(properties
		sel_20 {pts2510}
		sel_621 230
		sel_622 160
		sel_623 280
		sel_624 140
		sel_625 100
		sel_626 250
		sel_627 1305
		sel_628 163
		sel_629 15
		sel_630 150
	)
)
