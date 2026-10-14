;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1883)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	TutSmith 9
)

(instance TutSmith of Talker
	(properties
		name {TutSmith}
		x 5
		y 5
		view 1883
		loop 3
		talkWidth 150
		back 15
		textX 112
		textY 12
	)

	(method (init)
		(= font gUserFont)
		(super init: tutSmithBust tutSmithEyes tutSmithMouth &rest)
	)
)

(instance tutSmithBust of Prop
	(properties
		name {tutSmithBust}
		view 1883
		loop 1
	)
)

(instance tutSmithEyes of Prop
	(properties
		name {tutSmithEyes}
		nsTop 44
		nsLeft 30
		view 1883
		loop 2
	)
)

(instance tutSmithMouth of Prop
	(properties
		name {tutSmithMouth}
		nsTop 65
		nsLeft 20
		view 1883
	)
)
