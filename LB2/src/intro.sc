;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	intro 0
)

(local
	local0
	local1 = 100
)

(instance intro of Rgn
	(properties
		sel_20 {intro}
	)

	(method (sel_110)
		(super sel_110:)
		(gTheIconBar sel_233:)
		(gTheIconBar sel_233: 7)
		(gGame sel_197: 996 1 304 172)
		(gUser sel_347: 1)
		(gKeyDownHandler sel_129: self)
	)

	(method (sel_133 param1)
		(if (and (== (param1 sel_31:) 4) (== (param1 sel_37:) 27))
			(param1 sel_73: 1)
			(gCurRoom sel_146: sFadeToBlack)
		)
	)

	(method (sel_399 param1)
		(gKeyDownHandler sel_81: self)
		(= sel_407 0)
		(if
			(not
				(= sel_406
					(OneOf
						param1
						100
						105
						110
						120
						140
						150
						155
						160
						180
						190
						220
					)
				)
			)
			(gTheIconBar sel_177:)
		)
	)
)

(instance sFadeToBlack of Script
	(properties
		sel_20 {sFadeToBlack}
	)

	(method (sel_57)
		(if (and local0 local1)
			(Palette palSET_INTENSITY 0 255 (-- local1))
			(if (not local1)
				(self sel_145:)
			)
		)
		(super sel_57:)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= local0 1)
			)
			(1
				(gCurRoom sel_399: 26)
			)
		)
	)
)
