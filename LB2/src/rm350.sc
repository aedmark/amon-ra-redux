;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use RotundaRgn)
(use Scaler)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm350 0
	proc350_2 2
	proc350_23 23
)

(local
	local0
)

(procedure (proc350_2)) ; UNUSED

(procedure (proc350_23)) ; UNUSED

(instance rm350 of LBRoom
	(properties
		name {rm350}
		noun 5
		picture 350
		north 420
		east 370
		south 335
		west 360
	)

	(method (init &tmp [temp0 5])
		(gEgo init: normalize: 831 setScale: Scaler 95 75 190 120)
		(if (== gAct 5)
			(LoadMany rsVIEW 424)
		)
		(if (> gAct 2)
			(self setRegions: 90)
		else
			(self setRegions: 93)
			((ScriptID 2350 0) doit: (= obstacles (List new:))) ; poly2350Code
		)
		(switch gPrevRoomNum
			(north
				(if (== gAct 5)
					(gEgo
						x: 275
						y: 100
						setSpeed: 6
						setStep: 2 1
						setHeading: 180
					)
					(self setScript: sLauraDies)
				else
					(gEgo posn: 270 100 edgeHit: 0 setHeading: 180)
				)
			)
			(south
				(self setScript: sEnterSouth)
			)
			(330
				(self setScript: sEnterSouth 0 1)
			)
			(east
				(= style 11)
			)
			(west
				(= style 12)
			)
			(340 ; testRoom
				(= style 9)
			)
			(else
				(gEgo posn: 70 175)
				(= gAct 2)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (not script)
			(gGame handsOn:)
		)
		(southExitFeature init:)
		(eastExitFeature init:)
		(westExitFeature init:)
		(tables init:)
		(waterGlass1 init: approachVerbs: 4)
		(waterGlass2 init: approachVerbs: 4)
		(waterGlass3 init: approachVerbs: 4)
		(tutHead init:)
		(plants init:)
		(arch init:)
		(column1 init:)
		(column2 init:)
		(if (== gAct 2)
			(partyATP1 init: setScale: 170 addToPic:)
			(partyATP2 init: setScale: 170 addToPic:)
			(partyATP3 init: setScale: 170 addToPic:)
			(partyATP4 init: setScale: 170 addToPic:)
		)
		(cond
			((not (== gAct 2)))
			(
				(and
					(IsFlag 122)
					(TimeCheck $7204) ; has 7:30 pm occurred?
					(not (TimeCheck $0008))
					(> (gEgo y:) 175)
					(not (OneOf global128 0 1 4 5 9 13))
				)
				(self setScript: sMeetSteve)
			)
			(else
				(switch global128
					(0
						((ScriptID 93 6) ; Pippin
							setLoop: 8
							setCel: 4
							posn: 158 179
							addToPic:
						)
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 5
							posn: 180 179
							addToPic:
						)
						((ScriptID 93 10) ; Watney
							setLoop: 8
							setCel: 1
							posn: 192 180
							addToPic:
						)
						((ScriptID 93 11) ; Yvette
							setLoop: 8
							setCel: 2
							posn: 166 180
							addToPic:
						)
						((ScriptID 93 12) ; Ziggy
							setLoop: 8
							setCel: 0
							posn: 149 182
							addToPic:
						)
					)
					(1
						((ScriptID 93 6) ; Pippin
							setLoop: 8
							setCel: 4
							posn: 158 180
							addToPic:
						)
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 5
							posn: 180 179
							addToPic:
						)
						((ScriptID 93 10) ; Watney
							setLoop: 8
							setCel: 1
							posn: 192 185
							addToPic:
						)
						((ScriptID 93 12) ; Ziggy
							setLoop: 8
							setCel: 0
							posn: 149 182
							addToPic:
						)
					)
					(2
						((ScriptID 93 1) ; Countess
							setLoop: 8
							setCel: 3
							posn: 140 182
							addToPic:
						)
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 1
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 12) ; Ziggy
							setLoop: 8
							setCel: 0
							posn: 165 182
							addToPic:
						)
					)
					(3
						((ScriptID 93 1) ; Countess
							setLoop: 8
							setCel: 3
							posn: 140 182
							addToPic:
						)
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 5
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 12) ; Ziggy
							setLoop: 8
							setCel: 0
							posn: 165 182
							addToPic:
						)
					)
					(4
						((ScriptID 93 1) ; Countess
							setLoop: 8
							setCel: 5
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 2
							posn: 165 182
							addToPic:
						)
					)
					(5
						((ScriptID 93 1) ; Countess
							setLoop: 8
							setCel: 5
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 12) ; Ziggy
							setLoop: 8
							setCel: 0
							posn: 160 182
							addToPic:
						)
					)
					(6
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 5
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 9) ; Tut
							setLoop: 8
							setCel: 4
							posn: 165 182
							addToPic:
						)
					)
					(7
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 5
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 9) ; Tut
							setLoop: 8
							setCel: 4
							posn: 165 182
							addToPic:
						)
					)
					(8
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 1
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 9) ; Tut
							setLoop: 8
							setCel: 4
							posn: 150 182
							addToPic:
						)
						((ScriptID 93 11) ; Yvette
							setLoop: 8
							setCel: 2
							posn: 165 180
							addToPic:
						)
					)
					(9
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 2
							posn: 165 179
							addToPic:
						)
						((ScriptID 93 9) ; Tut
							setLoop: 8
							setCel: 5
							posn: 180 180
							setScale: 170
							addToPic:
						)
						((ScriptID 93 11) ; Yvette
							setLoop: 8
							setCel: 0
							posn: 155 182
							addToPic:
						)
					)
					(10
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 5
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 9) ; Tut
							setLoop: 8
							setCel: 4
							posn: 165 182
							addToPic:
						)
					)
					(11
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 5
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 9) ; Tut
							setLoop: 8
							setCel: 4
							posn: 165 182
							addToPic:
						)
					)
					(12
						((ScriptID 93 7) ; Rameses
							setLoop: 8
							setCel: 1
							posn: 180 182
							addToPic:
						)
						((ScriptID 93 11) ; Yvette
							setLoop: 8
							setCel: 0
							posn: 160 182
							addToPic:
						)
					)
					(13
						((ScriptID 93 8) ; Steve
							setLoop: 8
							setCel: 4
							posn: 160 181
							addToPic:
						)
						((ScriptID 93 11) ; Yvette
							setLoop: 8
							setCel: 2
							posn: 175 183
							addToPic:
						)
					)
				)
			)
		)
		(if (and (== gPrevRoomNum 340) (== gCurRoomNum (RotundaRgn convRoom:))) ; testRoom
			(while (StepOn gEgo 8)
				(gEgo
					x: (- (gEgo x:) 1)
					y: (- (gEgo y:) 1)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			(
				(and
					(== gAct 2)
					(StepOn gEgo 8)
					(== gCurRoomNum (RotundaRgn convRoom:))
				)
				(RotundaRgn notify:)
			)
			((StepOn gEgo 2)
				(self setScript: sExitNorth)
			)
			((and (StepOn gEgo 4) (not (== gAct 2)))
				(self setScript: sCantLeave)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 2350)
	)

	(method (doVerb param1)
		(if (== param1 4)
			(gMessager say: noun param1 (if (> gAct 2) 5 else 4))
		else
			(super doVerb: param1)
		)
	)

	(method (newRoom param1)
		(if (== param1 south)
			(DrawPic 780 10)
		)
		(super newRoom: param1)
	)
)

(instance sEnterSouth of Script
	(properties
		name {sEnterSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(SetFlag 25)
				(if (== (gGameMusic1 number:) 335)
					(gGameMusic1 fade: 127 5 5 0)
				else
					(gGameMusic1 number: 335 flags: 1 setLoop: -1 play:)
				)
				(gEgo
					edgeHit: 0
					posn: 100 225
					setMotion: PolyPath 100 180 self
				)
				(if register
					((ScriptID 93 8) ; Steve
						init:
						posn: 110 230
						setCycle: StopWalk -1
						setMotion: PolyPath 110 180 self
					)
				else
					(= cycles 1)
				)
			)
			(1 0)
			(2
				(if register
					(gEgo setSpeed: (= gSpeed global149))
					((ScriptID 93 8) illegalBits: 0 setMotion: PolyPath 330 180 self) ; Steve
				else
					(= cycles 1)
				)
			)
			(3
				(if register
					((ScriptID 93 8) dispose:) ; Steve
				)
				(gGame handsOn:)
				(gEgo normalize: 831)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties
		name {sExitNorth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				; The doorway's opening tops out at y 57; at this depth Laura is
				; 37 pixels tall, so walking 15 pixels in put her head over the
				; lintel. Step to the doorway's centre and leave (PLAY-017).
				(gEgo setMotion: MoveTo 268 (- (gEgo y:) 1) self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sCantLeave of Script
	(properties
		name {sCantLeave}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 180 self)
			)
			(1
				(if (not (SetFlag 70))
					(gMessager say: 12 1 2)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMeetSteve of Script
	(properties
		name {sMeetSteve}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				; Meet beside the guests at the table rather than among them,
				; on Laura's side, so neither walks through anyone (PLAY-016).
				(if (< (gEgo x:) 160)
					((ScriptID 93 8) ; Steve
						setCycle: StopWalk -1
						posn: 30 183
						loop: 0
						init:
						setMotion: PolyPath 75 183
					)
					(gEgo setMotion: PolyPath 112 183 self)
				else
					((ScriptID 93 8) ; Steve
						setCycle: StopWalk -1
						posn: 290 183
						loop: 1
						init:
						setMotion: PolyPath 250 183
					)
					(gEgo setMotion: PolyPath 215 183 self)
				)
			)
			(1
				(Face gEgo (ScriptID 93 8)) ; Steve
				(Face (ScriptID 93 8) gEgo) ; Steve
				(= cycles 2)
			)
			(2
				(gMessager say: 15 0 0 0 self)
			)
			(3
				(gEgo
					setStep: 3 2
					setMotion: PolyPath (gEgo x:) 240 self
				)
			)
			(4
				((ScriptID 93 8) ; Steve
					setMotion: PolyPath ((ScriptID 93 8) x:) 250 self ; Steve
				)
			)
			(5
				((ScriptID 22 0) doit: 8) ; triggerAndClock
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance sGetWaterGlass of Script
	(properties
		name {sGetWaterGlass}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gEgo
					view: 855
					setCel: 0
					setLoop: (if (== register waterGlass3) 0 else 1)
					cycleSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo
					get: 28
					normalize: 831
					loop: (if (== register waterGlass3) 6 else 7)
				)
				((ScriptID 21 0) doit: 797) ; addCluesCode
				(self dispose:)
			)
		)
	)
)

(instance sLauraDies of Script
	(properties
		name {sLauraDies}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveFwd 80)
				(oriley
					init:
					posn: 270 85
					setScale: 165
					setHeading: 180
					setCycle: StopWalk -1
					setMotion: MoveFwd 20 self
				)
				(gGameMusic1 number: 3 flags: 1 loop: 1 play:)
			)
			(2
				(oriley view: 424 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(thudSound play:)
				(gEgo setMotion: 0 view: 858 setLoop: 4 setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		name {oriley}
		view 423
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsLeft 6
		nsBottom 189
		nsRight 314
		cursor 11
		exitDir 3
		noun 12
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		name {eastExitFeature}
		nsTop 94
		nsLeft 315
		nsBottom 189
		nsRight 320
		cursor 14
		exitDir 2
		noun 14
	)
)

(instance westExitFeature of ExitFeature
	(properties
		name {westExitFeature}
		nsTop 94
		nsBottom 189
		nsRight 5
		cursor 12
		exitDir 4
		noun 13
	)
)

(instance tables of Feature
	(properties
		name {tables}
		y 152
		noun 1
		sightAngle 40
		onMeCheck 4096
	)
)

(instance waterGlass1 of Feature
	(properties
		name {waterGlass1}
		x 42
		y 153
		noun 8
		nsTop 132
		nsLeft 30
		nsBottom 142
		nsRight 54
		sightAngle 40
		approachX 61
		approachY 168
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if (gEgo has: 28)
					(gMessager say: noun param1 3)
				else
					(gCurRoom setScript: sGetWaterGlass 0 self)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance waterGlass2 of Feature
	(properties
		name {waterGlass2}
		x 211
		y 153
		noun 8
		nsTop 147
		nsLeft 206
		nsBottom 157
		nsRight 217
		sightAngle 40
		approachX 227
		approachY 174
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if (gEgo has: 28)
					(gMessager say: noun param1 3)
				else
					(gCurRoom setScript: sGetWaterGlass 0 self)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance waterGlass3 of Feature
	(properties
		name {waterGlass3}
		x 110
		y 153
		noun 8
		nsTop 141
		nsLeft 104
		nsBottom 152
		nsRight 116
		sightAngle 40
		approachX 90
		approachY 170
	)

	(method (doVerb param1)
		(switch param1
			(4
				(if (gEgo has: 28)
					(gMessager say: noun param1 3)
				else
					(gCurRoom setScript: sGetWaterGlass 0 self)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance tutHead of Feature
	(properties
		name {tutHead}
		x 160
		y 100
		noun 2
		sightAngle 40
		onMeCheck 16384
	)
)

(instance plants of Feature
	(properties
		name {plants}
		x 100
		y 100
		noun 3
		onMeCheck 8192
	)
)

(instance arch of Feature
	(properties
		name {arch}
		x 268
		y 72
		noun 6
		nsTop 56
		nsLeft 255
		nsBottom 89
		nsRight 281
		sightAngle 40
	)
)

(instance column1 of Feature
	(properties
		name {column1}
		x 27
		y 68
		noun 4
		nsTop 50
		nsLeft 24
		nsBottom 87
		nsRight 31
		sightAngle 40
	)
)

(instance column2 of Feature
	(properties
		name {column2}
		x 289
		y 71
		noun 4
		nsTop 53
		nsLeft 286
		nsBottom 89
		nsRight 293
		sightAngle 40
	)
)

(instance partyATP1 of View
	(properties
		name {partyATP1}
		x 287
		y 151
		noun 7
		view 374
		cel 15
		signal 16384
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance partyATP2 of View
	(properties
		name {partyATP2}
		x 271
		y 145
		noun 7
		view 374
		signal 16384
	)

	(method (init)
		(= cel
			(switch (Random 0 8)
				(0 6)
				(1 9)
				(2 10)
				(3 11)
				(4 13)
				(5 17)
				(6 18)
				(7 20)
				(8 30)
			)
		)
		(= loop (/ cel 16))
		(= cel (mod cel 16))
		(super init:)
		(self addToPic:)
	)
)

(instance partyATP3 of View
	(properties
		name {partyATP3}
		x 50
		y 130
		noun 7
		view 374
		signal 16384
	)

	(method (init)
		(= cel
			(switch (Random 0 5)
				(0 3)
				(1 4)
				(2 19)
				(3 25)
				(4 27)
				(5 31)
			)
		)
		(= loop (/ cel 16))
		(= cel (mod cel 16))
		(super init:)
		(self addToPic:)
	)
)

(instance partyATP4 of View
	(properties
		name {partyATP4}
		x 28
		y 131
		noun 7
		view 374
		signal 16384
	)

	(method (init)
		(= cel
			(switch (Random 0 4)
				(0 2)
				(1 7)
				(2 24)
				(3 26)
				(4 29)
			)
		)
		(= loop (/ cel 16))
		(= cel (mod cel 16))
		(super init:)
		(self addToPic:)
	)
)

(instance thudSound of Sound
	(properties
		name {thudSound}
		flags 5
		number 80
	)
)
