;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Path)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm210 0
)

(local
	[local0 5] = [140 165 350 165 -32768]
	[local5 5] = [150 167 519 167 -32768]
	[local10 5] = [127 172 370 172 -32768]
)

(instance rm210 of LBRoom
	(properties
		name {rm210}
		noun 16
		picture 210
		north 230
		south 280
		vanishingX 150
		vanishingY 112
	)

	(method (init)
		(LoadMany rsVIEW 214 210 284 212 213 852 803)
		(LoadMany rsSOUND 190 40 252)
		(self setRegions: 91)
		(gEgo normalize: 803 init:)
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: 0 setHeading: 180 setScale: 0 normalize: 803)
			)
			(south
				(gCurRoom setScript: sOverControl)
			)
			(else
				(gEgo x: 150 y: 187)
				(taxi setScale: Scaler 105 0 190 112 init: posn: 190 195)
				(gCurRoom setScript: sOutCab)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						319
						0
						319
						176
						199
						176
						88
						184
						80
						183
						73
						180
						48
						174
						39
						173
						32
						165
						11
						152
						6
						167
						25
						170
						31
						180
						0
						180
						0
						0
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						187
						154
						187
						154
						182
						177
						182
						177
						187
						194
						187
						194
						189
					yourself:
				)
		)
		(if (gEgo has: 0)
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 224 177 235 182 216 185 205 179
						yourself:
					)
			)
			(luigi approachVerbs: 4 2 6 10 init: setCycle: Fwd)
			(gGameMusic1 number: 190 loop: -1 flags: 1 play:)
		)
		(frontDoor init:)
		(taxiSign approachVerbs: 4 addToPic:)
		(if (> (gGame detailLevel:) 2)
			(man1
				init:
				setLoop: 0
				setCycle: Walk
				setMotion: MoveTo 198 176 man1
			)
			(person2
				init:
				setLoop: 2
				setStep: 1 1
				setCycle: Walk
				setMotion: MoveTo -20 183 person2
			)
			(person3
				init:
				setLoop: 3
				setStep: 1 1
				setCycle: Walk
				setMotion: MoveTo 208 179 person3
			)
			(person4
				init:
				setLoop: 5
				setCycle: Walk
				setMotion: person4Path person4
			)
		)
		(person6
			init:
			setLoop: 7
			setStep: 2 2
			setCycle: Walk
			setMotion: person6Path person6
		)
		(person8
			init:
			setLoop: 11
			setCycle: Walk
			setMotion: MoveTo 202 176 person8
		)
		(car2
			init:
			setLoop: 6
			cel: (Random 0 4)
			moveSpeed: 4
			setMotion: car2Path car2
		)
		(greyBuilding init:)
		(nextBuilding init:)
		(gothicEntrance init:)
		(newsBuilding init:)
		(tree init:)
		(southExitFeature init:)
	)

	(method (dispose)
		(gGameMusic1 fade:)
		(DisposeScript 983)
		(super dispose:)
	)
)

(instance sOverControl of Script
	(properties
		name {sOverControl}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo x: 134 y: 185)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 134 180 self)
			)
			(2
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
				(= cycles 1)
			)
			(1
				((ScriptID 91 1) pause:) ; streetSounds
				(gGameMusic2 send: 2 224 2000)
				(gEgo posn: 147 185)
				(taxi setLoop: 4 setMotion: MoveTo 105 227 self)
				(gGameMusic2 fade:)
			)
			(2
				((ScriptID 91 1) pause: 0) ; streetSounds
				(gGame handsOn:)
				(taxi dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMoveMan1 of Script
	(properties
		name {sMoveMan1}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(man1 setLoop: 1 posn: 194 175 setMotion: MoveTo 163 173 self)
			)
			(1
				(= seconds (Random 3 12))
			)
			(2
				(man1
					posn: -10 188
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 198 176 self
				)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sMovePerson2 of Script
	(properties
		name {sMovePerson2}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(person2
					setLoop: 8
					setStep: 2 2
					posn: 166 172
					setMotion: MoveTo 194 176 self
				)
			)
			(2
				(person2 loop: 9 setMotion: MoveTo -20 189 self)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sMovePerson3 of Script
	(properties
		name {sMovePerson3}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(person3 loop: 4 posn: 209 176 setMotion: MoveTo 170 172 self)
			)
			(1
				(= seconds (Random 1 6))
			)
			(2
				(person3 loop: 3 posn: -10 185 setMotion: MoveTo 208 176 self)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sMovePerson8 of Script
	(properties
		name {sMovePerson8}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(person8
					loop: 12
					posn: 203 175
					setMotion: MoveTo 158 173 self
				)
			)
			(1
				(= seconds (Random 5 10))
			)
			(2
				(person8 posn: -5 189 loop: 11 setMotion: MoveTo 202 176 self)
			)
			(3
				(= state -1)
				(= cycles 1)
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
				(gGameMusic2 number: 252 loop: -1 flags: 1 play: 20)
				(gGame handsOff:)
				((ScriptID 91 1) pause:) ; streetSounds
				(= cycles 1)
			)
			(1
				(gEgo
					view: 852
					loop: 1
					posn: (- (gEgo x:) 2) (- (gEgo y:) 1)
					setScale: Scaler 102 0 190 112
					setCycle: End self
				)
				(noise number: 97 play:)
			)
			(2
				(taxi init: setScale: Scaler 116 0 190 112 posn: 378 181)
				(gGameMusic2 send: 2 224 2000 fade: 127 5 5 0)
				(= cycles 1)
			)
			(3
				(taxi
					setLoop: 4
					xStep: 4
					setMotion:
						MoveTo
						(+ (taxiSign x:) 25)
						(+ (taxiSign y:) 10)
						self
				)
			)
			(4
				(gGameMusic2 send: 2 224 1600)
				(= cycles 1)
			)
			(5
				(gGameMusic2 send: 2 224 1200)
				(= cycles 1)
			)
			(6
				(gGameMusic2 send: 2 224 800)
				(= cycles 1)
			)
			(7
				(gGameMusic2 send: 2 224 400)
				(= cycles 1)
			)
			(8
				(gGameMusic2 send: 2 224 0)
				(noise number: 40 flags: 5 play: self)
				(if (gCast contains: luigi)
					(luigi setScript: 0 addToPic:)
				)
			)
			(9
				(gEgo
					view: 803
					setLoop: 4
					setMotion:
						MoveTo
						(+ (gEgo x:) 17)
						(gEgo y:)
						self
				)
			)
			(10
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance sGetSandwich of Script
	(properties
		name {sGetSandwich}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 3 10 0 1 self)
				(luigi posn: 221 179 setCycle: 0)
			)
			(2
				(gMessager say: 3 10 0 2 self)
			)
			(3
				(luigi loop: 1 posn: 217 180 cycleSpeed: 10 setCycle: End self)
			)
			(4
				(gMessager say: 3 10 0 3 self)
			)
			(5
				(gCurRoom setInset: sandwichI self)
			)
			(6
				(luigi loop: 0 posn: 221 179 setCycle: Fwd)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetSandwichInset of Script
	(properties
		name {sGetSandwichInset}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gEgo put: 0)
				((ScriptID 21 1) doit: 769) ; dropCluesCode
				((ScriptID 21 0) doit: 772) ; addCluesCode
				(sandwichI dispose:)
				(luigi loop: 0 posn: 217 180 setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(gEgo get: 3)
				(self dispose:)
			)
		)
	)
)

(instance luigi of Prop
	(properties
		name {luigi}
		x 221
		y 179
		noun 3
		approachX 189
		approachY 181
		view 214
		signal 16384
	)

	(method (init)
		(cart
			posn: (- (self x:) 13) (+ (self y:) 5)
			init:
			stopUpd:
		)
		(super init:)
	)

	(method (dispose)
		(cart dispose:)
		(super dispose:)
	)

	(method (doVerb param1 &tmp temp0)
		(switch param1
			(10
				(gCurRoom setScript: sGetSandwich)
			)
			(2
				(cond
					((and (not (gEgo has: 0)) (not (IsFlag 28)))
						(SetFlag 28)
						(gMessager say: 3 2 1 0)
					)
					((not (gEgo has: 0))
						(gMessager say: 3 2 2 0)
					)
					((gEgo has: 0)
						(gMessager say: 3 2 3 0)
					)
				)
			)
			(6
				(= global178 2) ; PLAY-008: bit 1 marks topics Luigi has answered
				(cond
					(
						(and
							(<=
								256
								(= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
							)
							(<= temp0 409)
						)
						(gMessager say: 3 6 4)
					)
					((and (<= 512 temp0) (<= temp0 665))
						(gMessager say: 3 6 5)
					)
					((== temp0 772)
						(gMessager say: 3 6 8)
					)
					((and (<= 768 temp0) (<= temp0 921))
						(gMessager say: 3 6 6)
					)
					((and (<= 1024 temp0) (<= temp0 1177))
						(gMessager say: 3 6 7)
					)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance cart of View
	(properties
		name {cart}
		noun 4
		view 214
		loop 3
		signal 16385
	)
)

(instance sandwichI of Inset
	(properties
		name {sandwichI}
		view 214
		loop 4
		x 141
		y 90
		disposeNotOnMe 1
		noun 2
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn:)
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sGetSandwichInset)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance frontDoor of Door
	(properties
		name {frontDoor}
		x 39
		y 167
		noun 5
		approachX 36
		approachY 175
		view 210
		entranceTo 230
		moveToX 22
		moveToY 169
		enterType 0
		exitType 0
	)
)

(instance taxiSign of View
	(properties
		name {taxiSign}
		x 165
		y 185
		noun 6
		approachX 150
		approachY 187
		view 284
		cel 2
		signal 16385
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sHailTaxi)
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
		x 375
		y 181
		noun 13
		view 852
		loop 4
	)
)

(instance man1 of Actor
	(properties
		name {man1}
		x 117
		y 188
		noun 9
		view 212
		signal 16384
	)

	(method (cue)
		(man1 setScript: sMoveMan1)
	)
)

(instance person2 of Actor
	(properties
		name {person2}
		x 140
		y 180
		noun 9
		view 212
		loop 2
		signal 16384
	)

	(method (cue)
		(person2 setScript: sMovePerson2)
	)
)

(instance person3 of Actor
	(properties
		name {person3}
		x -10
		y 183
		noun 9
		view 212
		loop 3
		signal 16384
	)

	(method (cue)
		(person3 setScript: sMovePerson3)
	)
)

(instance person4 of Actor
	(properties
		name {person4}
		x 140
		y 165
		noun 9
		view 212
		loop 5
		priority 11
		signal 16400
	)

	(method (cue)
		(person4 posn: 140 165 setMotion: person4Path self)
	)
)

(instance person4Path of Path
	(properties
		name {person4Path}
	)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance person6 of Actor
	(properties
		name {person6}
		x 150
		y 167
		noun 9
		view 212
		loop 7
		priority 11
		signal 16400
	)

	(method (cue)
		(person6 posn: 150 167 setMotion: person6Path self)
	)
)

(instance person6Path of Path
	(properties
		name {person6Path}
	)

	(method (at param1)
		(return [local5 param1])
	)
)

(instance person8 of Actor
	(properties
		name {person8}
		x -5
		y 189
		noun 9
		view 212
		loop 11
		signal 16384
	)

	(method (cue)
		(person8 setScript: sMovePerson8)
	)
)

(instance car of Actor
	(properties
		name {car}
		x 154
		y 189
		noun 13
		view 213
		cel 1
		priority 14
		signal 16400
	)

	(method (cue)
		(car dispose:)
	)
)

(instance car2 of Actor
	(properties
		name {car2}
		x 127
		y 172
		noun 13
		view 213
		loop 7
		cel 3
		signal 16384
	)

	(method (cue)
		(car2 posn: 127 172 cel: (Random 0 4) setMotion: car2Path self)
	)
)

(instance car2Path of Path
	(properties
		name {car2Path}
	)

	(method (at param1)
		(return [local10 param1])
	)
)

(instance greyBuilding of Feature
	(properties
		name {greyBuilding}
		y 100
		noun 10
		onMeCheck 8192
	)
)

(instance nextBuilding of Feature
	(properties
		name {nextBuilding}
		y 180
		noun 7
		onMeCheck 16384
	)
)

(instance gothicEntrance of Feature
	(properties
		name {gothicEntrance}
		y 100
		noun 5
		onMeCheck 4096
	)
)

(instance newsBuilding of Feature
	(properties
		name {newsBuilding}
		y 100
		noun 15
		onMeCheck 2048
	)
)

(instance tree of Feature
	(properties
		name {tree}
		y 190
		noun 19
		onMeCheck 1024
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsLeft 195
		nsBottom 189
		nsRight 289
		cursor 11
		exitDir 3
		noun 18
	)
)

(instance noise of Sound
	(properties
		name {noise}
		flags 1
	)
)
