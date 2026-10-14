;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	streetRgn 0
	streetSounds 1
)

(local
	local0
	local1
	local2
	local3
)

(instance streetRgn of Rgn
	(properties
		name {streetRgn}
	)

	(method (init)
		(Load rsVIEW 853)
		(LoadMany rsSOUND 96 94 81)
		(leftFeature init:)
		(rightFeature init:)
		(car setLoop: 3 setCel: 3 xStep: 6 moveSpeed: 3 hide:)
		(if (not (streetSounds handle:))
			(streetSounds play:)
		)
		(super init:)
	)

	(method (doit)
		(cond
			((gCurRoom script:))
			((and (== local0 1) (== local1 1) (StepOn gEgo 4))
				(gCurRoom setScript: sLeaveNow)
			)
			((and (not (and (== local0 1) (== local1 1))) (StepOn gEgo 4))
				(gCurRoom setScript: sRunOver)
			)
			((StepOn gEgo 256)
				(gCurRoom setScript: sHitEdgeScreen)
			)
		)
		(super doit:)
	)

	(method (newRoom param1)
		(= keep (OneOf param1 280 210 260 300))
		(= initialized 0)
	)
)

(instance sLeaveNow of Script
	(properties
		name {sLeaveNow}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo heading: 180)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveFwd 65 self)
			)
			(2
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sRunOver of Script
	(properties
		name {sRunOver}
	)

	(method (doit)
		(cond
			((and (< (car distanceTo: gEgo) 160) (not local2))
				(mRunOver number: 96 loop: -1 play:)
				(= local2 1)
			)
			((and (< (car distanceTo: gEgo) 100) (not local3))
				(mRunOver number: 81 loop: 1 play:)
				(= local3 1)
			)
		)
		(super doit:)
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(streetSounds stop:)
				(if (== gCurRoomNum 280)
					((ScriptID 280 1) dispose:) ; carSound
					((ScriptID 280 2) setScript: 0) ; drunk
				)
				(gEgo setPri: 13)
				(car init:)
				(= cycles 1)
			)
			(1
				(car
					setMotion:
						MoveTo
						(+ (gEgo x:) 55)
						(- (gEgo y:) 1)
						self
				)
			)
			(2
				(switch gCurRoomNum
					(210
						(car setMotion: MoveTo 160 225)
					)
					(260
						(car setMotion: MoveTo -30 251)
					)
					(280
						(car setMotion: MoveTo 112 221)
					)
					(300
						(car setMotion: MoveTo 220 215)
					)
				)
				(= cycles 1)
			)
			(3
				(gEgo
					view: 853
					loop: (if (== (gEgo view:) 803) 1 else 0)
					cel: 0
					posn: (- (gEgo x:) 19) (- (gEgo y:) 1)
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(4
				(= seconds 7)
				(if (gEgo looper:)
					(gEgo setLoop: 0)
				)
			)
			(5
				(= global145 9) ; "If you don't look both ways, you'll be dead in no time flat!"
				(gCurRoom newRoom: 99)
			)
		)
	)
)

(instance sHitEdgeScreen of Script
	(properties
		name {sHitEdgeScreen}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gMessager say: 4 3 0 0 self 91)
			)
			(1
				(if (> (gEgo heading:) 180)
					(gEgo setHeading: 90)
				else
					(gEgo setHeading: 270)
				)
				(gEgo setMotion: MoveFwd 10 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leftFeature of Feature
	(properties
		name {leftFeature}
		x 28
		y 100
		nsTop 88
		nsBottom 189
		nsRight 20
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(1
				(= local0 1)
				(gMessager say: 1 1 0 0 0 91)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance rightFeature of Feature
	(properties
		name {rightFeature}
		x 287
		y 100
		nsTop 88
		nsLeft 300
		nsBottom 189
		nsRight 320
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(1
				(= local1 1)
				(gMessager say: 2 1 0 0 0 91)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance car of Actor
	(properties
		name {car}
		x 362
		y 181
		view 213
		loop 3
		cel 3
		signal 16384
		moveSpeed 3
	)
)

(instance mRunOver of Sound
	(properties
		name {mRunOver}
		flags 5
	)
)

(instance streetSounds of Sound
	(properties
		name {streetSounds}
		flags 1
		number 94
		loop -1
	)
)
