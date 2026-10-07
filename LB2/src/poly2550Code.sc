;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2550)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2550Code 0
	pts2550 1
)

(local
	[theSel_87 38] = [0 0 319 0 319 189 236 189 210 143 252 143 246 137 272 137 272 132 242 132 233 124 226 124 223 128 162 128 156 128 147 124 97 122 33 164 0 189]
	[theSel_87_2 10] = [131 125 157 131 157 159 53 159 99 125]
)
(instance poly2550Code of Code
	(properties
		sel_20 {poly2550Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2550a sel_110: sel_117:) (poly2550b sel_110: sel_117:)
		)
	)
)

(instance poly2550a of Polygon
	(properties
		sel_20 {poly2550a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 19)
		(= sel_87 @theSel_87)
	)
)

(instance poly2550b of Polygon
	(properties
		sel_20 {poly2550b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 5)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2550 of MuseumPoints
	(properties
		sel_20 {pts2550}
		sel_621 140
		sel_622 160
		sel_625 140
		sel_626 250
		sel_627 1245
		sel_628 135
	)
)
