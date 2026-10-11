;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2480)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2480Code 0
	pts2480 1
)

(local
	[local0 24] = [0 0 319 0 319 77 181 121 159 108 124 108 128 114 155 114 177 124 3 160 3 188 0 189]
	[local24 8] = [80 250 -4 175 114 158 231 240]
	[local32 10] = [289 102 345 100 319 189 310 198 133 150]
)

(instance poly2480Code of Code
	(properties
		sel_20 {poly2480Code}
	)

	(method (sel_57 param1)
		(param1
			sel_118:
				(poly2480a sel_110: sel_117:)
				(poly2480b sel_110: sel_117:)
				(poly2480c sel_110: sel_117:)
		)
	)
)

(instance poly2480a of Polygon
	(properties
		sel_20 {poly2480a}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 12)
		(= sel_87 @local0)
	)
)

(instance poly2480b of Polygon
	(properties
		sel_20 {poly2480b}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 4)
		(= sel_87 @local24)
	)
)

(instance poly2480c of Polygon
	(properties
		sel_20 {poly2480c}
	)

	(method (sel_110)
		(= sel_31 2)
		(= sel_86 5)
		(= sel_87 @local32)
	)
)

(instance pts2480 of MuseumPoints
	(properties
		sel_20 {pts2480}
		sel_621 115
		sel_622 150
		sel_623 150
		sel_624 110
	)
)
