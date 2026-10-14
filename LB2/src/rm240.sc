;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use eRS)
(use Conversation)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm240 0
	local_Steve 12
)

(local
	[local0 57] = [-1 10 6 19 1 0 0 0 -1 10 6 19 2 0 0 0 -1 10 6 19 3 0 0 0 -1 10 6 19 4 0 0 0 -1 10 6 19 5 0 0 0 -1 10 6 19 6 0 0 0 -1 10 6 19 7 0 0 0 0]
	local57
	local58
	local59
)

(instance rm240 of LBRoom
	(properties
		name {rm240}
		picture 120
		style 10
		east 250
		vanishingX 187
		vanishingY 135
	)

	(method (init)
		(LoadMany rsVIEW 852 284 1125 125 830 121)
		(LoadMany rsSOUND 40 120 121)
		(gEgo init: setScale: Scaler 145 20 187 135 normalize: 830)
		(switch gPrevRoomNum
			(east
				(if (IsFlag 9)
					(gCurRoom setScript: sEnterEastN)
				else
					(steve init: setScale: Scaler 197 10 187 135)
					(self
						addObstacle:
							(= local59
								((Polygon new:)
									type: 2
									init: 199 159 199 171 160 171 160 159
									yourself:
								)
							)
					)
					(gCurRoom setScript: sEnterEast1)
				)
			)
			(else
				(gEgo posn: 160 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						84
						154
						83
						176
						183
						176
						243
						176
						243
						164
						212
						164
						212
						154
						242
						154
						242
						142
						162
						142
						91
						154
					yourself:
				)
		)
		(gGameMusic1 number: 121 loop: -1 flags: 1 play:)
		(gGameMusic2 fade:)
		(person1 init: setStep: 1 1)
		(person2 init: setStep: 1 1)
		(person3 init: setStep: 1 1)
		(taxiSign init:)
		(ship init:)
		(crate init:)
		(warehouses init:)
		(city init:)
		(city1 init:)
		(cityLeft init:)
		(sky init:)
		(skyleft init:)
		(water init:)
		(pilingRt init:)
		(pilingL init:)
		(docks init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 256)
				(gCurRoom setScript: sHitEdgeScreen)
			)
		)
	)

	(method (dispose)
		(gGameMusic1 fade:)
		(noConvTimer dispose: delete:)
		(super dispose:)
	)
)

(instance sEnterEast1 of Script
	(properties
		name {sEnterEast1}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				((ScriptID 22 0) doit: 2) ; triggerAndClock
				(gGame points: 1 130)
				((ScriptID 1881 2) ; Laura
					x: 203
					y: 17
					textX: -180
					textY: 0
				)
				(gEgo
					edgeHit: 0
					posn: 250 159
					setHeading: 270
					setMotion: MoveFwd 38 self
				)
				(steve setLoop: 5 setCycle: Walk setMotion: MoveTo 180 166 self)
			)
			(1 0)
			(2
				(steve
					setLoop: 8
					cel: 0
					posn: 180 165
					cycleSpeed: 12
					setScript: sSteveAnimates
				)
				(gGame handsOn:)
				(SetFlag 9)
				(person1 setScript: moveItAround)
				(= seconds 1)
			)
			(3
				(gMessager say: 14 0 0 1)
				(person3 setScript: (moveItAround new:))
				(= seconds 1)
			)
			(4
				(person2 setScript: (moveItAround new:))
				(= seconds 1)
			)
			(5
				(noConvTimer setReal: noConvTimer 15)
				(self dispose:)
			)
		)
	)
)

(instance sEnterEastN of Script
	(properties
		name {sEnterEastN}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo
					edgeHit: 0
					posn: 250 150
					setHeading: 270
					setMotion: MoveFwd 35 self
				)
			)
			(1
				(gGame handsOn:)
				(person1 setScript: moveItAround)
				(= seconds 2)
			)
			(2
				(person3 setScript: (moveItAround new:))
				(= cycles 5)
			)
			(3
				(person2 setScript: (moveItAround new:))
				(= seconds 6)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sSteveAnimates of Script
	(properties
		name {sSteveAnimates}
	)

	(method (changeState param1 &tmp temp0)
		(switch (= state param1)
			(0
				(= seconds (Random 4 8))
			)
			(1
				(switch (= temp0 (Random 0 3))
					(0
						(steve loop: 8 setCycle: End self)
					)
					(1
						(if (== (Random 0 3) 0)
							(steve loop: 9 setCycle: End self)
						else
							(= temp0 3)
							(= cycles 1)
						)
					)
					(2
						(steve loop: 10 setCycle: End self)
					)
					(3
						(= seconds (Random 2 4))
					)
				)
			)
			(2
				(= seconds (Random 4 8))
			)
			(3
				(if (!= temp0 3) ; UNINIT
					(steve setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance moveItAround of Script
	(properties
		name {moveItAround}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(client setMotion: MoveTo 194 127 self)
			)
			(1
				(client posn: 234 137 setMotion: MoveTo 191 138 self)
			)
			(2
				(switch (Random 0 1)
					(0
						(client
							setMotion:
								MoveTo
								(Random 138 174)
								(Random 136 140)
								self
						)
					)
					(1
						(= seconds 2)
					)
				)
			)
			(3
				(client setMotion: MoveTo 191 138 self)
			)
			(4
				(client setMotion: MoveTo 234 137 self)
			)
			(5
				(client loop: (Random 0 4) posn: 169 121)
				(= seconds 2)
			)
			(6
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sTalkSteve of Script
	(properties
		name {sTalkSteve}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(noConvTimer setReal: noConvTimer 15)
				(= cycles 1)
			)
			(1
				(SetFlag 122)
				((ScriptID 21 0) doit: 263) ; addCluesCode
				(if (< (gEgo x:) 181)
					(gEgo setMotion: PolyPath 162 165 self)
				else
					(gEgo setMotion: PolyPath 204 169 self)
				)
			)
			(2
				(Face gEgo steve self)
			)
			(3
				(= cycles 4)
			)
			(4
				(switch (++ local57)
					(1
						(gMessager say: 10 2 1 0 self)
						((ScriptID 21 0) doit: 263) ; addCluesCode
					)
					(2
						(gMessager say: 10 2 2 0 self)
					)
					(3
						(gMessager say: 10 2 3 0 self)
					)
					(4
						(gMessager say: 10 2 4 0 self)
					)
					(5
						(gMessager say: 10 2 5 0 self)
					)
					(else
						(gMessager say: 10 2 6 0 self)
					)
				)
				(= seconds 1)
			)
			(5
				(= cycles 4)
			)
			(6
				(noConvTimer setReal: noConvTimer 15)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAskSteve of Script
	(properties
		name {sAskSteve}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(noConvTimer setReal: noConvTimer 15)
				(= cycles 1)
			)
			(1
				(SetFlag 122)
				((ScriptID 21 0) doit: 263) ; addCluesCode
				(if (< (gEgo x:) 181)
					(gEgo setMotion: PolyPath 162 165 self)
				else
					(gEgo setMotion: PolyPath 204 169 self)
				)
			)
			(2
				(Face gEgo steve self)
			)
			(3
				(gGame handsOff:)
				(= cycles 4)
			)
			(4
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(262
						(gMessager say: 10 6 7 0 self)
					)
					(261
						(gMessager say: 10 6 8 0 self)
					)
					(264
						(gMessager say: 10 6 9 0 self)
					)
					(260
						(gMessager say: 10 6 10 0 self)
					)
					(259
						((ScriptID 21 0) doit: 269) ; addCluesCode
						(gMessager say: 10 6 11 0 self)
					)
					(269
						(gMessager say: 10 6 12 0 self)
					)
					(258
						(switch (++ local58)
							(1
								(gMessager say: 10 6 13 0 self)
							)
							(else
								(gMessager say: 10 6 14 0 self)
							)
						)
					)
					(263
						(gMessager say: 10 6 26 0 self)
					)
					(780
						((ScriptID 21 0) doit: 258) ; addCluesCode
						(gMessager say: 10 6 15 0 self)
					)
					(518
						(gMessager say: 10 6 16 0 self)
					)
					(516
						(gMessager say: 10 6 17 0 self)
					)
					(514
						(gMessager say: 10 6 18 0 self)
					)
					(519
						(gMessager say: 10 6 27 0 self)
					)
					(517
						(self setScript: sAskMuseum self)
					)
					(1026
						(gMessager say: 10 6 28 0 self)
					)
					(773
						(gMessager say: 10 6 20 0 self)
					)
					(772
						(gMessager say: 10 6 22 0 self)
					)
					(769
						(gMessager say: 10 6 21 0 self)
					)
					(771
						(gMessager say: 10 6 23 0 self)
					)
					(-1
						(= cycles 1)
					)
					(else
						(gMessager say: 10 6 25 0 self)
					)
				)
			)
			(5
				(= cycles 4)
			)
			(6
				(if (gCast contains: steve)
					(noConvTimer setReal: noConvTimer 15)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAskMuseum of Script
	(properties
		name {sAskMuseum}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(noConvTimer dispose: delete:)
				((ScriptID 21 0) doit: 258) ; addCluesCode
				(myConv load: @local0 init: self)
				(steve setScript: 0)
			)
			(1
				(steve
					setLoop: 6
					posn: (- (steve x:) 2) (+ (steve y:) 3)
					ignoreActors: 1
					setCycle: End self
				)
			)
			(2
				(steve
					setLoop: 7
					posn: (+ (steve x:) 2) (- (steve y:) 1)
					setHeading: 0
					setStep: 1 1
					moveSpeed: 9
					setCycle: Walk
					setMotion: MoveTo (steve x:) 140 self
				)
				(= seconds 5)
			)
			(3
				(if seconds
					(= seconds 0)
				)
				(gGame handsOn:)
				(steve dispose:)
				((gCurRoom obstacles:) delete: local59)
				(local59 dispose:)
				(self dispose:)
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
				(= cycles 1)
			)
			(1
				(if (gCast contains: steve)
					(steve setScript: 0)
				)
				(gEgo setMotion: PolyPath 213 152 self)
			)
			(2
				(gEgo
					view: 852
					loop: 0
					cel: 0
					setScale: Scaler 170 20 187 135
					setCycle: End self
				)
				(if (gCast contains: steve)
					(steve
						setLoop: 7
						setHeading: 0
						setStep: 1 1
						moveSpeed: 9
						setMotion: MoveTo (steve x:) 140
					)
				)
				(noise number: 97 flags: 1 play:)
			)
			(3
				(taxi
					init:
					setPri: 11
					setScale: Scaler 187 70 187 135
					setLoop: 4
				)
				(= cycles 1)
			)
			(4
				(gGameMusic2 play:)
				(taxi setMotion: MoveTo 281 154 self)
			)
			(5
				(taxi setMotion: MoveTo 293 163 self)
			)
			(6
				(gEgo
					normalize: 830
					setHeading: 90
					setScale: Scaler 145 20 187 135
					setMotion: MoveFwd 32 self
				)
			)
			(7
				(noise number: 40 flags: 5 play: self)
			)
			(8
				(gCurRoom newRoom: 250)
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
				(= cycles 1)
			)
			(1
				(gMessager say: 4 3 0 0 self 91)
			)
			(2
				(if (> (gEgo heading:) 180)
					(gEgo setHeading: 90)
				else
					(gEgo setHeading: 270)
				)
				(gEgo setMotion: MoveFwd 25 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance person1 of Actor
	(properties
		name {person1}
		x 169
		y 121
		view 121
		priority 3
		signal 18448
		scaleSignal 1
		moveSpeed 25
	)
)

(instance person2 of Actor
	(properties
		name {person2}
		x 169
		y 121
		view 121
		loop 1
		priority 3
		signal 18448
		scaleSignal 1
		moveSpeed 27
	)
)

(instance person3 of Actor
	(properties
		name {person3}
		x 169
		y 121
		view 121
		loop 2
		priority 3
		signal 18448
		scaleSignal 1
		moveSpeed 24
	)
)

(instance steve of Actor
	(properties
		name {steve}
		x 184
		y 140
		noun 9
		view 121
		loop 5
		signal 16384
	)

	(method (doVerb param1)
		(switch param1
			(2
				(gCurRoom setScript: sTalkSteve)
			)
			(6
				(gCurRoom setScript: sAskSteve)
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
		x 225
		y 160
		noun 13
		view 284
		cel 2
		signal 16384
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sHailCab)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance taxi of Actor
	(properties
		name {taxi}
		x 290
		y 146
		view 852
		loop 4
	)
)

(instance ship of Feature
	(properties
		name {ship}
		y 100
		noun 1
		onMeCheck 16384
	)
)

(instance crate of Feature
	(properties
		name {crate}
		x 113
		y 189
		noun 5
		nsTop 164
		nsLeft 88
		nsBottom 179
		nsRight 139
		sightAngle 40
	)
)

(instance warehouses of Feature
	(properties
		name {warehouses}
		x 209
		y 128
		noun 4
		nsTop 121
		nsLeft 189
		nsBottom 136
		nsRight 230
		sightAngle 40
	)
)

(instance city of Feature
	(properties
		name {city}
		x 199
		y 82
		noun 3
		nsTop 46
		nsLeft 188
		nsBottom 119
		nsRight 210
		sightAngle 40
	)
)

(instance city1 of Feature
	(properties
		name {city1}
		x 204
		y 93
		noun 3
		nsTop 67
		nsLeft 177
		nsBottom 120
		nsRight 231
		sightAngle 40
	)
)

(instance cityLeft of Feature
	(properties
		name {cityLeft}
		x 95
		y 100
		noun 3
		nsTop 72
		nsLeft 88
		nsBottom 128
		nsRight 103
		sightAngle 40
	)
)

(instance sky of Feature
	(properties
		name {sky}
		x 199
		y 26
		noun 2
		nsTop 8
		nsLeft 168
		nsBottom 45
		nsRight 231
		sightAngle 40
	)
)

(instance skyleft of Feature
	(properties
		name {skyleft}
		x 107
		y 20
		noun 2
		nsTop 6
		nsLeft 89
		nsBottom 35
		nsRight 126
		sightAngle 40
	)
)

(instance water of Feature
	(properties
		name {water}
		x 99
		y 139
		noun 7
		nsTop 135
		nsLeft 87
		nsBottom 144
		nsRight 112
		sightAngle 40
	)
)

(instance pilingRt of Feature
	(properties
		name {pilingRt}
		x 214
		y 168
		noun 8
		nsTop 151
		nsLeft 198
		nsBottom 185
		nsRight 230
		sightAngle 40
	)
)

(instance pilingL of Feature
	(properties
		name {pilingL}
		x 171
		y 176
		noun 8
		nsTop 169
		nsLeft 150
		nsBottom 183
		nsRight 193
		sightAngle 40
	)
)

(instance docks of Feature
	(properties
		name {docks}
		y 160
		noun 6
		onMeCheck 8192
	)
)

(instance myConv of Conversation
	(properties
		name {myConv}
	)
)

(instance local_Steve of Talker
	(properties
		name {local Steve}
		x 9
		y 85
		view 125
		loop 3
		priority 15
		signal 16
		disposeWhenDone 0
		talkWidth 130
		back 15
		textX 130
		textY -75
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 tSteveEyes tSteveMouth &rest)
	)
)

(instance tSteveMouth of Prop
	(properties
		name {tSteveMouth}
		nsTop 34
		nsLeft 57
		view 1125
		priority 15
		signal 16400
	)
)

(instance tSteveEyes of Prop
	(properties
		name {tSteveEyes}
		nsTop 29
		nsLeft 58
		view 1125
		loop 2
		priority 15
		signal 16400
	)
)

(instance noConvTimer of Timer
	(properties
		name {noConvTimer}
	)

	(method (cue)
		(cond
			((and (not (gCurRoom script:)) (gCast contains: steve))
				(gMessager say: 14 0 0 2)
				(noConvTimer setReal: noConvTimer 15)
			)
			((not (gCast contains: steve))
				(noConvTimer dispose: delete:)
			)
			(else
				(self setReal: self 5)
			)
		)
	)
)

(instance noise of Sound
	(properties
		name {noise}
		flags 1
	)
)
