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
		name {intro}
	)

	(method (init)
		(super init:)
		(gTheIconBar disable:)
		(gTheIconBar disable: 7)
		(gGame setCursor: 996 1 304 172)
		(gUser canInput: 1)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent param1)
		(if (and (== (param1 type:) 4) (== (param1 message:) 27))
			(param1 claimed: 1)
			(gCurRoom setScript: sFadeToBlack)
		)
	)

	(method (newRoom param1)
		(gKeyDownHandler delete: self)
		(= initialized 0)
		(if
			(not
				(= keep
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
			(gTheIconBar enable:)
		)
	)
)

(instance sFadeToBlack of Script
	(properties
		name {sFadeToBlack}
	)

	(method (doit)
		(if (and local0 local1)
			(Palette palSET_INTENSITY 0 255 (-- local1))
			(if (not local1)
				(self cue:)
			)
		)
		(super doit:)
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= local0 1)
			)
			(1
				(gCurRoom newRoom: 26)
			)
		)
	)
)
