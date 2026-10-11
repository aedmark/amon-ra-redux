;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2430)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2430Code 0
	pts2430 1
)

(local
	[local0 32] = [11 185 307 185 307 139 292 129 319 129 319 125 270 125 270 114 120 114 110 70 108 114 92 114 85 123 24 116 76 129 11 163]
	[local32 30] = [34 156 307 156 307 139 292 129 319 129 319 125 270 125 270 114 120 114 110 70 102 114 92 114 85 123 24 116 76 129]
)

(instance poly2430Code of Code
	(properties
		sel_20 {poly2430Code}
	)

	(method (sel_57 param1)
		(param1
			sel_118:
				(if
					(or
						(> gAct 3)
						(and (== gAct 3) (TimeCheck $b102 1)) ; can 11:15 pm occur?
					)
					(poly2430b sel_110: sel_117:)
				else
					(poly2430a sel_110: sel_117:)
				)
		)
	)
)

(instance poly2430a of Polygon
	(properties
		sel_20 {poly2430a}
	)

	(method (sel_110)
		(= sel_31 3)
		(= sel_86 16)
		(= sel_87 @local0)
	)
)

(instance poly2430b of Polygon
	(properties
		sel_20 {poly2430b}
	)

	(method (sel_110)
		(= sel_31 3)
		(= sel_86 15)
		(= sel_87 @local32)
	)
)

(instance pts2430 of MuseumPoints
	(properties
		sel_20 {pts2430}
		sel_621 150
		sel_622 130
		sel_623 115
		sel_624 95
		sel_627 315
		sel_628 127
		sel_629 44
		sel_630 119
	)
)
