;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2335)
(include sci.sh)
(use Main)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2335Code 0
	pts2335 1
)

(local
	[local0 28] = [85 179 85 189 0 189 0 0 319 0 319 189 284 189 284 158 190 176 161 167 161 134 150 134 150 168 143 179]
	[local28 26] = [85 179 85 189 0 189 0 0 319 0 319 189 284 189 284 158 178 170 161 167 161 134 150 134 150 168]
)

(instance poly2335Code of Code
	(properties
		sel_20 {poly2335Code}
	)

	(method (sel_57 param1 param2)
		(if (> argc 1)
			; RestoreGame can replace the Polygon's points pointer with the copy
			; stored in an old save. Restore the known-good current static boundary.
			(poly2335a sel_31: 2 sel_86: 14 sel_87: @local0 sel_256: 0)
		else
			(if (and (== gAct 2) (not (IsFlag 25)))
				(param1 sel_118: (poly2335a sel_110: sel_117:))
			else
				(param1 sel_118: (poly2335b sel_110: sel_117:))
			)
		)
	)
)

(instance poly2335a of Polygon
	(properties
		sel_20 {poly2335a}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 14)
		(= sel_87 @local0)
	)
)

(instance poly2335b of Polygon
	(properties
		sel_20 {poly2335b}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 13)
		(= sel_87 @local28)
	)
)

(instance pts2335 of MuseumPoints
	(properties
		sel_20 {pts2335}
	)
)
