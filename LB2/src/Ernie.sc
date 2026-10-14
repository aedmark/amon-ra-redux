;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1893)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Ernie 23
)

(instance Ernie of Talker
	(properties
		name {Ernie}
		x 5
		y 5
		view 1893
		loop 3
		talkWidth 150
		back 15
		textX 120
		textY 12
	)

	(method (init)
		(= font gUserFont)
		(super init: ernieBust ernieEyes ernieMouth &rest)
	)
)

(instance ernieBust of Prop
	(properties
		name {ernieBust}
		view 1893
		loop 1
	)
)

(instance ernieEyes of Prop
	(properties
		name {ernieEyes}
		nsTop 31
		nsLeft 25
		view 1893
		loop 2
	)
)

(instance ernieMouth of Prop
	(properties
		name {ernieMouth}
		nsTop 50
		nsLeft 25
		view 1893
	)
)
