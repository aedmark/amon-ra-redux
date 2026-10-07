;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2600)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2600Code 0
	pts2600 1
)

(local
	[theSel_87 34] = [49 189 0 189 0 0 319 0 319 184 282 174 282 165 312 159 310 156 271 163 271 171 232 164 153 167 146 137 123 137 123 169 73 170]
	[theSel_87_2 12] = [212 189 202 182 244 172 263 181 262 189 211 189]
)
(instance poly2600Code of Code
	(properties
		sel_20 {poly2600Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118: (poly2600a sel_110: sel_117:) (poly2600b sel_110: sel_117:)
		)
	)
)

(instance poly2600a of Polygon
	(properties
		sel_20 {poly2600a}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 17)
		(= sel_87 @theSel_87)
	)
)

(instance poly2600b of Polygon
	(properties
		sel_20 {poly2600b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 6)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2600 of MuseumPoints
	(properties
		sel_20 {pts2600}
		sel_621 120
		sel_622 180
		sel_623 1135
		sel_624 165
		sel_625 120
		sel_626 250
		sel_627 1285
		sel_628 165
	)
)
