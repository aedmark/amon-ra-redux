;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
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
	rm260 0
	Stinky 32
	Biff 33
	Tubby 34
)

(local
	local0 = 1
	local1 = 1
	local2 = 1
)

(instance rm260 of LBRoom
	(properties
		name {rm260}
		noun 13
		picture 260
		north 270
		south 300
		vanishingY 50
	)

	(method (init)
		(LoadMany rsVIEW 284 260 852 282 830)
		(LoadMany rsSOUND 40 97 260 261)
		(self setRegions: 91)
		(gEgo init: normalize: 830 setScale: Scaler 98 0 190 50)
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
		(gGameMusic1 number: 260 flags: 1 loop: 1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						319
						0
						319
						189
						311
						189
						311
						166
						151
						171
						142
						159
						122
						159
						122
						165
						143
						165
						147
						171
						90
						171
						83
						145
						61
						143
						78
						172
						63
						172
						63
						178
						9
						178
						9
						189
						0
						189
						0
						0
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 92 174 127 174 127 179 92 179
					yourself:
				)
		)
		(if (not (IsFlag 129))
			(kidR init: approachVerbs: 6 4 2 8 15 setScript: (sKidsPlaying new:))
			(kidL init: approachVerbs: 6 4 2 8 15 setScript: (sKidsPlaying new:))
			(kid init: approachVerbs: 6 4 2 8 15 setScript: (sKidsPlaying new:))
		)
		(southExitFeature init:)
		(sky init:)
		(window1 init:)
		(window2 init:)
		(store init:)
		(lofats init:)
		(storeSign init:)
		(lamp1 init:)
		(lamp2 init:)
		(plant1 init:)
		(plant2 init:)
		(street init:)
		(stairs init:)
		(streetLamp init:)
		(frontDoor init:)
		(taxiSign init:)
		(taxi init: setScale: 220)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 16)
				(gCurRoom setScript: sDownStairs)
			)
		)
	)

	(method (dispose)
		(carSound dispose:)
		(gGameMusic1 fade: 0 30 12 1)
		(super dispose: &rest)
	)
)

(instance sDownStairs of Script
	(properties
		name {sDownStairs}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(gEgo setMotion: PolyPath 91 174 self)
			)
			(2
				(gMessager say: 11 0 11 0 self)
			)
			(3
				(gGame handsOn:)
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
				(gEgo setMotion: PolyPath 161 170 self)
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
				(gEgo x: 127 y: 171)
				(taxi init: posn: 115 188 setLoop: 5)
				(= cycles 1)
			)
			(1
				(gGameMusic2 send: 2 224 2000 fade:)
				(taxi setMotion: MoveTo -30 251 self)
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

(instance sKidsPlaying of Script
	(properties
		name {sKidsPlaying}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(client setCycle: CT (Random 1 5) 1 self)
			)
			(1
				(= ticks (Random 10 120))
			)
			(2
				(client setCycle: End self)
			)
			(3
				(= ticks (Random 10 120))
			)
			(4
				(client setCycle: CT (Random 1 5) -1 self)
			)
			(5
				(= ticks (Random 10 120))
			)
			(6
				(client setCycle: Beg self)
			)
			(7
				(= ticks (Random 10 120))
			)
			(8
				(self changeState: 0)
			)
		)
	)
)

(instance sTradeBaseBall of Script
	(properties
		name {sTradeBaseBall}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(kid setScript: 0)
				(kidL cel: 0)
				(= cycles 1)
			)
			(2
				(gEgo view: 282 loop: 5 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 18 7 0 0 self)
				(kidL setCycle: CT 8 1)
			)
			(4
				(kid loop: 3 cel: 0 setCycle: CT 7 1 self)
			)
			(5
				(kid setCycle: End self)
				(kidL setCycle: CT 0 -1)
			)
			(6
				(kid loop: 0)
				(= cycles 1)
			)
			(7
				(kid setScript: sKidsPlaying)
				(gGame points: 1 129)
				((ScriptID 22 0) doit: 4) ; triggerAndClock
				((ScriptID 21 0) doit: 791) ; addCluesCode
				((ScriptID 21 1) doit: 773) ; dropCluesCode
				(gEgo put: 4 get: 22 setCycle: Beg self)
			)
			(8
				(gGameMusic2 number: 261 flags: 1 loop: 1 play:)
				(gEgo view: 830 setCycle: StopWalk -1)
				(= cycles 2)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHailTaxi of Script
	(properties
		name {sHailTaxi}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(- (taxiSign x:) 20)
						(+ (taxiSign y:) 2)
						self
				)
			)
			(1
				(gGameMusic2 number: 252 flags: 1 loop: -1 play: 20)
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
				(taxi
					init:
					setLoop: 5
					setMotion:
						MoveTo
						(+ (gEgo x:) 28)
						(+ (gEgo y:) 11)
						self
				)
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
				(gEgo normalize: 830 ignoreActors: setMotion: MoveTo 122 185 self)
			)
			(8
				(gGameMusic2 send: 2 224 0)
				(carSound play:)
				(gEgo hide:)
				(= cycles 5)
			)
			(9
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance frontDoor of Door
	(properties
		name {frontDoor}
		x 155
		y 112
		noun 1
		approachX 151
		approachY 172
		view 260
		entranceTo 270
		moveToX 126
		moveToY 164
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 135 162 162 162 162 169 135 169)
	)
)

(instance kid of Prop
	(properties
		name {kid}
		x 40
		y 172
		noun 18
		approachX 63
		approachY 172
		view 282
		signal 20480
		cycleSpeed 8
	)

	(method (doVerb param1 &tmp temp0)
		(switch param1
			(6
				(= global178 3) ; PLAY-008: bit 2 marks topics the street kid has answered
				(switch (= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
					(1026
						(gMessager say: 18 6 5)
					)
					(1027
						(gMessager say: 18 6 6)
					)
					(1028
						(gMessager say: 18 6 10)
					)
					(519
						(gMessager say: 18 6 4)
					)
					(else
						(cond
							((< temp0 512)
								(gMessager say: 18 6 1)
							)
							((< temp0 768)
								(gMessager say: 18 6 2)
							)
							((< temp0 1024)
								(gMessager say: 18 6 3)
							)
						)
					)
				)
			)
			(7
				(gCurRoom setScript: sTradeBaseBall)
			)
			(4
				(if local0
					(gMessager say: 18 4 7)
					(= local0 0)
				else
					(gMessager say: 18 4 8)
				)
			)
			(2
				(if local1
					(gMessager say: 18 2 7)
					(= local1 0)
				else
					(gMessager say: 18 2 8)
				)
			)
			(1
				(if (IsFlag 129)
					(gMessager say: 18 1 12)
				else
					(super doVerb: param1)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance kidR of Prop
	(properties
		name {kidR}
		x 42
		y 174
		noun 17
		approachX 63
		approachY 172
		view 282
		loop 1
		signal 20480
		cycleSpeed 8
	)

	(method (doVerb param1 &tmp temp0)
		(switch param1
			(6
				(= global178 3) ; PLAY-008: bit 2 marks topics the street kid has answered
				(switch (= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
					(1026
						(gMessager say: 17 6 5)
					)
					(1027
						(gMessager say: 17 6 6)
					)
					(1028
						(gMessager say: 17 6 10)
					)
					(519
						(gMessager say: 17 6 4)
					)
					(else
						(cond
							((< temp0 512)
								(gMessager say: 17 6 1)
							)
							((< temp0 768)
								(gMessager say: 17 6 2)
							)
							((< temp0 1024)
								(gMessager say: 17 6 3)
							)
						)
					)
				)
			)
			(2
				(cond
					((IsFlag 129)
						(gMessager say: 17 2 12)
					)
					(local2
						(gMessager say: 17 2 7)
						(= local2 0)
					)
					(else
						(gMessager say: 17 2 8)
					)
				)
			)
			(1
				(if (IsFlag 129)
					(gMessager say: 17 1 12)
				else
					(super doVerb: param1)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance kidL of Prop
	(properties
		name {kidL}
		x 29
		y 173
		noun 19
		approachX 63
		approachY 172
		view 282
		loop 2
		signal 20480
		cycleSpeed 8
	)

	(method (doVerb param1 &tmp temp0)
		(switch param1
			(6
				(= global178 3) ; PLAY-008: bit 2 marks topics the street kid has answered
				(switch (= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
					(1026
						(gMessager say: 19 6 5)
					)
					(1027
						(gMessager say: 19 6 6)
					)
					(1028
						(gMessager say: 19 6 10)
					)
					(519
						(gMessager say: 19 6 4)
					)
					(else
						(cond
							((< temp0 512)
								(gMessager say: 19 6 1)
							)
							((< temp0 768)
								(gMessager say: 19 6 2)
							)
							((< temp0 1024)
								(gMessager say: 19 6 3)
							)
						)
					)
				)
			)
			(2
				(if (IsFlag 129)
					(gMessager say: 19 2 12)
				else
					(super doVerb: param1)
				)
			)
			(1
				(if (IsFlag 129)
					(gMessager say: 19 1 12)
				else
					(super doVerb: param1)
				)
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
		cel 1
		cycleSpeed 4
		moveSpeed 0
	)
)

(instance Biff of Narrator
	(properties
		name {Biff}
		back 15
	)

	(method (init)
		(= font gUserFont)
		(= showTitle 1)
		(super init: &rest)
	)
)

(instance Stinky of Narrator
	(properties
		name {Stinky}
		back 15
	)

	(method (init)
		(= font gUserFont)
		(= showTitle 1)
		(super init: &rest)
	)
)

(instance Tubby of Narrator
	(properties
		name {Tubby}
		back 15
	)

	(method (init)
		(= font gUserFont)
		(= showTitle 1)
		(super init: &rest)
	)
)

(instance taxiSign of View
	(properties
		name {taxiSign}
		x 109
		y 175
		noun 3
		sightAngle 40
		view 284
		loop 1
		cel 1
		signal 16384
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sHailTaxi)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance sky of Feature
	(properties
		name {sky}
		y 3
		noun 16
		onMeCheck 8
	)
)

(instance window1 of Feature
	(properties
		name {window1}
		y 3
		noun 4
		nsTop 33
		nsLeft 28
		nsBottom 71
		nsRight 57
	)
)

(instance window2 of Feature
	(properties
		name {window2}
		y 3
		noun 4
		nsTop 43
		nsLeft 75
		nsBottom 74
		nsRight 98
	)
)

(instance store of Feature
	(properties
		name {store}
		y 3
		noun 5
		nsTop 78
		nsBottom 169
		nsRight 64
	)
)

(instance lofats of Feature
	(properties
		name {lofats}
		y 3
		noun 6
		nsTop 92
		nsLeft 108
		nsBottom 166
		nsRight 206
	)
)

(instance storeSign of Feature
	(properties
		name {storeSign}
		y 4
		noun 7
		nsTop 102
		nsLeft 148
		nsBottom 111
		nsRight 188
	)
)

(instance lamp1 of Feature
	(properties
		name {lamp1}
		y 4
		noun 8
		nsTop 97
		nsLeft 125
		nsBottom 118
		nsRight 137
	)
)

(instance lamp2 of Feature
	(properties
		name {lamp2}
		y 4
		noun 8
		nsTop 104
		nsLeft 189
		nsBottom 118
		nsRight 198
	)
)

(instance plant1 of Feature
	(properties
		name {plant1}
		y 3
		noun 9
		nsTop 64
		nsLeft 110
		nsBottom 79
		nsRight 135
	)
)

(instance plant2 of Feature
	(properties
		name {plant2}
		y 3
		noun 9
		nsTop 80
		nsLeft 163
		nsBottom 89
		nsRight 199
	)
)

(instance street of Feature
	(properties
		name {street}
		y 3
		noun 10
		nsTop 168
		nsBottom 189
		nsRight 319
	)
)

(instance stairs of Feature
	(properties
		name {stairs}
		y 3
		noun 11
		nsTop 89
		nsLeft 66
		nsBottom 169
		nsRight 101
	)
)

(instance streetLamp of Feature
	(properties
		name {streetLamp}
		y 3
		noun 12
		onMeCheck 2
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsBottom 189
		nsRight 320
		cursor 11
		exitDir 3
		noun 2
	)
)

(instance carSound of Sound
	(properties
		name {carSound}
		flags 5
		number 40
	)
)
