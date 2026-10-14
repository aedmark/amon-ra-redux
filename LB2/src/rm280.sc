;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use Inset)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm280 0
	carSound 1
	drunk 2
	Drunk 41
)

(instance rm280 of LBRoom
	(properties
		name {rm280}
		noun 6
		picture 280
		north 290
		south 210
		vanishingX 155
	)

	(method (init)
		(LoadMany rsVIEW 285 284 852 281 830 283)
		(LoadMany rsSOUND 40 97 281 280 252)
		(self setRegions: 91)
		(gEgo init: normalize: 830 setScale: Scaler 90 20 190 0)
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: 0 setHeading: 180)
			)
			(south
				(gCurRoom setScript: sUpCurb)
			)
			(else
				(gCurRoom setScript: sOutCab)
			)
		)
		(super init:)
		(gGameMusic1 number: 280 flags: 1 loop: 1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						121
						129
						101
						129
						123
						151
						124
						160
						94
						163
						94
						179
						55
						182
						49
						187
						206
						187
						195
						189
						0
						189
						0
						0
						319
						0
						319
						189
						311
						139
						256
						144
						288
						152
						226
						161
						209
						151
						182
						154
						168
						127
						140
						127
						140
						116
						148
						116
						148
						120
						162
						120
						162
						106
						121
						106
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 246 164 277 162 275 167 249 170
					yourself:
				)
		)
		(if (IsFlag 8)
			(if
				(not
					(if (or (gEgo has: 0) (gEgo has: 3))
					else
						(IsFlag 7)
					)
				)
				(newsPaper init: approachVerbs: 1 4 8)
			)
		else
			(drunk init: approachVerbs: 1 2 6 setScript: sSnore)
		)
		(column init:)
		(leftLion init:)
		(rightLion init:)
		(sidewalk init:)
		(steps init:)
		(street init:)
		(policeSign init:)
		(windows init:)
		(southExitFeature init:)
		(frontDoor init:)
		(stuckDoor init: approachVerbs: 4)
		(taxiSign init:)
		(taxi init: setScale: 200)
	)

	(method (dispose)
		(carSound dispose:)
		(gGameMusic1 fade: 0 30 12 1)
		(super dispose: &rest)
	)
)

(instance sPutUpInset of Script
	(properties
		name {sPutUpInset}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: (if register 3 else 14) 1 0 0 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sUpCurb of Script
	(properties
		name {sUpCurb}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 164 170 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOutCab of Script
	(properties
		name {sOutCab}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo x: 209 y: 172)
				(taxi init: x: 238 y: 189 setLoop: 5)
				(= cycles 1)
			)
			(1
				(gGameMusic2 send: 2 224 2000 fade:)
				(taxi setMotion: MoveTo 0 280 self)
			)
			(2
				(gGame handsOn:)
				(taxi posn: 411 171)
				(taxi dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sDrunkWakes of Script
	(properties
		name {sDrunkWakes}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(SetFlag 8)
				(gEgo setMotion: PolyPath 56 182 self)
			)
			(1
				(Face gEgo drunk self)
			)
			(2
				(gNarrator x: 15 y: 15)
				(gMessager say: 2 4 1 1)
				(gEgo view: 283 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(drunk setScript: 0 cycleSpeed: 10 setCycle: End self)
			)
			(4
				(gMessager say: 2 4 1 2)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo view: 830 setCycle: StopWalk -1)
				(gNarrator x: -1 y: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetNewsPaper of Script
	(properties
		name {sGetNewsPaper}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo view: 281 loop: 0 cel: 0 setCycle: CT 2 1 self)
				(newsPaper dispose:)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(gEgo get: 0)
				((ScriptID 21 0) doit: 769) ; addCluesCode
				(gEgo
					view: 830
					loop: 1
					cel: 1
					setCycle: StopWalk -1
					setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:) self
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sSnore of Script
	(properties
		name {sSnore}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= ticks 30)
			)
			(1
				(drunk setCycle: CT 2 1)
				(carSound number: 281 flags: 5 loop: 1 play: self)
			)
			(2
				(= ticks 30)
			)
			(3
				(drunk setCycle: CT 0 -1 self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sHailCab of Script
	(properties
		name {sHailCab}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gGameMusic2 number: 252 flags: 1 loop: -1 play: 20)
				(gEgo
					setMotion:
						PolyPath
						(- (taxiSign x:) 20)
						(+ (taxiSign y:) 2)
						self
				)
			)
			(1
				(gEgo
					view: 852
					loop: 0
					posn: (- (gEgo x:) 2) (gEgo y:)
					setCycle: End self
				)
				(gGameMusic1 number: 97 flags: 1 loop: 1 play:)
			)
			(2
				(gGameMusic2 send: 2 224 2000 fade: 127 5 5 0)
				(taxi init: setLoop: 5 setMotion: MoveTo 238 189 self)
			)
			(3
				(gGameMusic2 send: 2 224 1600)
				(= cycles 1)
			)
			(4
				(gGameMusic2 send: 2 224 1200)
				(= cycles 1)
			)
			(5
				(gGameMusic2 send: 2 224 800)
				(= cycles 1)
			)
			(6
				(gGameMusic2 send: 2 224 400)
				(= cycles 1)
			)
			(7
				(gGameMusic2 send: 2 224 0)
				(carSound number: 40 loop: 1 flags: 5 play:)
				(gEgo hide:)
				(= ticks 30)
			)
			(8
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance frontDoor of Door
	(properties
		name {frontDoor}
		x 120
		y 72
		noun 1
		approachX 131
		approachY 131
		view 281
		loop 2
		entranceTo 290
		moveToX 152
		moveToY 119
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 116 121 145 118 146 125 117 128)
	)
)

(instance drunk of Prop
	(properties
		name {drunk}
		x 20
		y 184
		noun 2
		approachX 56
		approachY 182
		view 283
		signal 16384
		cycleSpeed 30
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if (not (IsFlag 8))
					(gCurRoom setScript: sDrunkWakes)
				else
					(gMessager say: 2 4 2)
				)
			)
			(6
				(gMessager say: 2 6 4)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance taxi of Actor
	(properties
		name {taxi}
		x 411
		y 171
		view 852
		loop 5
		cycleSpeed 4
		moveSpeed 0
	)
)

(instance newsPaper of View
	(properties
		name {newsPaper}
		x 37
		y 187
		noun 11
		approachX 54
		approachY 186
		view 281
		loop 1
		signal 16384
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setInset: paperInset)
			)
			(1
				(gCurRoom setInset: paperInset)
			)
			(8
				(gCurRoom setInset: paperInset)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance taxiSign of View
	(properties
		name {taxiSign}
		x 257
		y 165
		noun 4
		sightAngle 40
		view 284
		loop 1
		cel 1
		priority 12
		signal 16400
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sHailCab)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance stuckDoor of Feature
	(properties
		name {stuckDoor}
		x 155
		y 98
		noun 1
		nsTop 73
		nsLeft 144
		nsBottom 123
		nsRight 167
		sightAngle 40
		approachX 131
		approachY 131
	)

	(method (doVerb param1)
		(frontDoor doVerb: param1)
	)
)

(instance column of Feature
	(properties
		name {column}
		y 3
		noun 15
		onMeCheck 8
	)
)

(instance leftLion of Feature
	(properties
		name {leftLion}
		y 3
		noun 9
		onMeCheck 64
	)

	(method (doVerb param1)
		(switch param1
			(6
				(gMessager say: 9 6 4)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance rightLion of Feature
	(properties
		name {rightLion}
		y 3
		noun 16
		onMeCheck 128
	)

	(method (doVerb param1)
		(switch param1
			(6
				(gMessager say: 16 6 4)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance sidewalk of Feature
	(properties
		name {sidewalk}
		y 3
		noun 12
		onMeCheck 2
	)
)

(instance steps of Feature
	(properties
		name {steps}
		y 3
		noun 10
		onMeCheck 16384
	)
)

(instance street of Feature
	(properties
		name {street}
		y 3
		noun 8
		onMeCheck 4
	)
)

(instance policeSign of Feature
	(properties
		name {policeSign}
		y 3
		noun 17
		nsTop 20
		nsLeft 115
		nsBottom 32
		nsRight 186
	)
)

(instance windows of Feature
	(properties
		name {windows}
		y 3
		noun 13
		onMeCheck 32
	)
)

(instance paperInset of Inset
	(properties
		name {paperInset}
		view 285
		loop 1
		x 7
		y 110
		disposeNotOnMe 1
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self setScript: sPutUpInset 0 0)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(self dispose:)
				(gCurRoom setInset: inCoupon)
			)
			(8
				(self dispose:)
				(gCurRoom setInset: inCoupon)
			)
			(1
				(self dispose:)
				(gCurRoom setInset: inCoupon)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance inCoupon of Inset
	(properties
		name {inCoupon}
		view 285
		x 7
		y 110
		disposeNotOnMe 1
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self setScript: sPutUpInset 0 1)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(self dispose:)
				(gCurRoom setScript: sGetNewsPaper)
			)
			(8
				(gMessager say: 3 1)
			)
			(1
				(gMessager say: 3 1)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsLeft 183
		nsBottom 189
		nsRight 320
		cursor 11
		exitDir 3
		noun 7
	)
)

(instance carSound of Sound
	(properties
		name {carSound}
		flags 5
		number 40
	)
)

(instance Drunk of Narrator
	(properties
		name {Drunk}
		back 15
	)

	(method (init)
		(= font gUserFont)
		(= showTitle 1)
		(super init: &rest)
	)
)
