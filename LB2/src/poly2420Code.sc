;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2420)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2420Code 0
	pts2420 1
)

(local
	[theSel_87 38] = [2 133 2 155 6 184 236 184 255 189 0 189 0 0 319 0 319 189 244 182 261 164 313 168 314 114 281 153 234 149 228 152 107 137 24 151 6 151]
	[theSel_87_2 8] = [108 142 198 151 127 174 50 161]
)
(instance poly2420Code of Code
	(properties
		sel_20 {poly2420Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2420a sel_110: sel_117:) (poly2420b sel_110: sel_117:)
		)
	)
)

(instance poly2420a of Polygon
	(properties
		sel_20 {poly2420a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 19)
		(= sel_87 @theSel_87)
	)
)

(instance poly2420b of Polygon
	(properties
		sel_20 {poly2420b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2420 of MuseumPoints
	(properties
		sel_20 {pts2420}
		sel_621 160
		sel_622 180
		sel_623 300
		sel_624 125
		sel_627 330
		sel_628 230
		sel_629 3
		sel_630 150
	)
)
