;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2435)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use Obj)

(public
	poly2435Code 0
	pts2435 1
)

(local
	[theSel_87 32] = [11 185 307 185 307 139 292 129 319 129 319 125 270 125 270 114 120 114 110 70 108 114 92 114 85 123 24 116 76 129 11 163]
	[theSel_87_2 30] = [34 156 307 156 307 139 292 129 319 129 319 125 270 125 270 114 120 114 110 70 102 114 92 114 85 123 24 116 76 129]
)
(instance poly2435Code of Code
	(properties
		sel_20 {poly2435Code}
	)
	
	(method (sel_57 param1)
		(param1
			sel_118:
				(if
					(or
						(> global123 3)
						(and (== global123 3) (proc0_10 -20222 1))
					)
					(poly2435b sel_110: sel_117:)
				else
					(poly2435a sel_110: sel_117:)
				)
		)
	)
)

(instance poly2435a of Polygon
	(properties
		sel_20 {poly2435a}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 16)
		(= sel_87 @theSel_87)
	)
)

(instance poly2435b of Polygon
	(properties
		sel_20 {poly2435b}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 15)
		(= sel_87 @theSel_87_2)
	)
)

(instance pts2435 of MuseumPoints
	(properties
		sel_20 {pts2435}
	)
)
