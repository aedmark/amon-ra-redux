;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2360)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2360Code 0
	pts2360 1
)

(local
	[local0 24] = [0 0 319 0 319 95 247 95 200 100 155 113 89 137 75 146 52 146 22 168 17 189 0 189]
	[local24 30] = [0 0 319 0 319 95 247 95 247 120 200 120 200 100 155 113 152 136 89 137 75 146 52 146 22 168 17 189 0 189]
	[theSel_87 10] = [258 164 420 164 420 179 245 179 241 168]
	[theSel_87_2 8] = [128 152 128 181 59 181 59 152]
	[theSel_87_3 8] = [148 176 191 176 191 189 148 189]
)
(instance poly2360Code of Code
	(properties
		sel_20 {poly2360Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2360a sel_110: sel_117:)
				(poly2360b sel_110: sel_117:)
				(if (== global123 2)
					(poly2360c sel_110: sel_117:)
				else
					0
				)
				(if (proc999_5 global128 2 3 10 11 12)
					(poly2360d sel_110: sel_117:)
				else
					0
				)
		)
	)
)

(instance poly2360a of Polygon
	(properties
		sel_20 {poly2360a}
	)
	
	(method (sel_110)
		(= sel_86 (if (> global123 (= sel_31 2)) 12 else 15))
		(= sel_87 (if (> global123 2) @local0 else @local24))
	)
)

(instance poly2360b of Polygon
	(properties
		sel_20 {poly2360b}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 5)
		(= sel_87 @theSel_87)
	)
)

(instance poly2360c of Polygon
	(properties
		sel_20 {poly2360c}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_2)
	)
)

(instance poly2360d of Polygon
	(properties
		sel_20 {poly2360d}
	)
	
	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @theSel_87_3)
	)
)

(instance pts2360 of MuseumPoints
	(properties
		sel_20 {pts2360}
		sel_621 220
		sel_622 130
		sel_627 330
		sel_628 120
	)
)
