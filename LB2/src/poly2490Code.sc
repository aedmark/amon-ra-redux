;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2490)
(include sci.sh)
(use MuseumPoints)
(use Polygon)
(use System)

(public
	poly2490Code 0
	pts2490 1
)

(local
	[local0 10] = [0 0 319 0 319 138 223 130 0 151]
)

(instance poly2490Code of Code
	(properties
		name {poly2490Code}
	)

	(method (doit param1)
		(param1 add: (poly2490a init: yourself:))
	)
)

(instance poly2490a of Polygon
	(properties
		name {poly2490a}
	)

	(method (init)
		(= type 2)
		(= size 5)
		(= points @local0)
	)
)

(instance pts2490 of MuseumPoints
	(properties
		name {pts2490}
		midPtX 125
		midPtY 160
		southPtX 125
		southPtY 250
	)
)
