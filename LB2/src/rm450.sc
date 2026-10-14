;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use Scaler)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm450 0
)

(local
	local0
)

(instance rm450 of LBRoom
	(properties
		name {rm450}
		noun 13
		picture 450
		south 448
		west 454
		vanishingX 172
		vanishingY 21
	)

	(method (init)
		(LoadMany rsVIEW 454 423 452 858 424)
		(LoadMany rsSOUND 450 600)
		(LoadMany rsSCRIPT 2450)
		(gEgo
			init:
			normalize: (if (== gAct 5) 426 else 831)
			setScale: Scaler 131 30 190 21
		)
		(if (== gAct 5)
			(self setRegions: 94)
			(gCurRoom obstacles: (List new:))
			((ScriptID 2450 0) doit: (gCurRoom obstacles:)) ; poly2450Code
		else
			(self setRegions: 90)
		)
		(switch gPrevRoomNum
			(west
				(gGame handsOn:)
				(= style 12)
				(if
					(and
						(IsFlag 35)
						(== gAct 3)
						(not (TimeCheck $a101 0)) ; has 10:15 pm occurred?
					)
					((ScriptID 90 15) seconds: 2) ; meetingTimer
				)
			)
			(south
				(= style 100)
				(gEgo x: 160 y: 350)
				(self setScript: sComeOnIn)
				(if (and (== gAct 5) (IsFlag 90))
					(self notify:)
				)
			)
			(else
				(gGame handsOn:)
				(gEgo x: 160 y: 160)
			)
		)
		(super init:)
		(if (and (!= gPrevRoomNum west) (< gAct 5))
			(if (== gAct 2)
				(gGameMusic1 pause:)
			else
					(WrapMusic pause:)
			)
			(gGameMusic2 number: 450 flags: 1 loop: -1 play:)
		)
		(if (IsFlag 38)
			(shatteredGlass init: stopUpd: approachVerbs: 1 4 8)
		else
			(glass init: stopUpd: approachVerbs: 1 4 8)
		)
		(pyramid init: approachVerbs: 1 4 8)
		(wallWindow init: approachVerbs: 1 4 8)
		(daggerCase init: approachVerbs: 1 4 8)
		(mummy init: approachVerbs: 1 4 8)
		(post init: approachVerbs: 1 4 8)
		(wings init: approachVerbs: 1 4 8)
		(rock1 init: approachVerbs: 1 4 8)
		(plaque init: approachVerbs: 1 4 8)
		(rock2 init: approachVerbs: 1 4 8)
		(westExitFeature init:)
		(southExitFeature init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 16)
				(self setScript: sEgoLeaveSouth)
			)
		)
	)

	(method (notify)
		(cond
			((gEgo script:)
				((gEgo script:)
					next: (if (== gAct 5) sDie else sLauraTutMeeting)
				)
			)
			((gCurRoom script:)
				((gCurRoom script:)
					next: (if (== gAct 5) sDie else sLauraTutMeeting)
				)
			)
			(else
				(gCurRoom
					setScript: (if (== gAct 5) sDie else sLauraTutMeeting)
				)
			)
		)
	)

	(method (dispose)
		(DisposeScript 2450)
		(super dispose: &rest)
	)

	(method (newRoom param1)
		(cond
			((and (== param1 south) (== gAct 2))
				(gGameMusic2 fade: 1)
				(gGameMusic1 pause: 0)
			)
			((and (== param1 south) (< gAct 5))
				(gGameMusic2 fade: 1)
					(WrapMusic pause: 0)
			)
		)
		(super newRoom: param1)
	)
)

(instance sComeOnIn of Script
	(properties
		name {sComeOnIn}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo posn: 160 300)
				(gEgo setMotion: MoveTo 160 160 self)
			)
			(2
				(if
					(and
						(IsFlag 35)
						(== gAct 3)
						(not (TimeCheck $a101 0)) ; has 10:15 pm occurred?
					)
					((ScriptID 90 15) seconds: 2) ; meetingTimer
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoLeaveSouth of Script
	(properties
		name {sEgoLeaveSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo heading: 180)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveFwd 75 self)
			)
			(2
				(gCurRoom newRoom: 448)
			)
		)
	)
)

(instance sLauraTutMeeting of Script
	(properties
		name {sLauraTutMeeting}
	)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not (gCurRoom inset:)))
			(self cue:)
		)
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
			)
			(1
				(if (== ((ScriptID 90 4) room:) 450) ; aTut
					((ScriptID 90 4) wandering: 0 setScript: 0) ; aTut
				else
					((ScriptID 90 4) ; aTut
						moveTo: 450
						view: 821
						x: 190
						y: 270
					)
				)
				(= cycles 2)
			)
			(2
				((ScriptID 90 4) setMotion: PolyPath 190 160 self) ; aTut
			)
			(3
				(gEgo setMotion: PolyPath 160 160 self)
			)
			(4
				(Face gEgo (ScriptID 90 4)) ; aTut
				(Face (ScriptID 90 4) gEgo) ; aTut
				(= cycles 4)
			)
			(5
				(= cycles 1)
			)
			(6
				(gMessager say: 1 0 1 0 self 1450)
			)
			(7
				((ScriptID 90 4) ; aTut
					wander:
						(if (!= ((ScriptID 90 4) originalDest:) 450) ; aTut
							((ScriptID 90 4) originalDest:) ; aTut
						else
							454
						)
						(ScriptID 90 4) ; aTut
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDie of Script
	(properties
		name {sDie}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 160 160 self)
			)
			(1
				(oriley
					init:
					setScale: Scaler 131 30 190 21
					setCycle: Walk
					setMotion: PolyPath 190 170 self
				)
				(gGameMusic1 number: 3 flags: 1 loop: 1 play:)
			)
			(2
				(oriley view: 424)
				(oriley cel: 0)
				(Face gEgo oriley)
				(Face oriley gEgo)
				(= cycles 4)
			)
			(3
				(oriley setCycle: End self)
			)
			(4
				(thudSound play:)
				(gEgo view: 858 setCycle: End self)
			)
			(5
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance sBreakIt of Script
	(properties
		name {sBreakIt}
	)

	(method (doit)
		(super doit:)
		(if (and (not local0) (== (glass cel:) 5))
			(nGlass play:)
			(= local0 1)
		)
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo view: 452 loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gEgo setCycle: End self)
				(glass setCycle: End self)
			)
			(2 0)
			(3
				(gMessager say: 4 4 1 0 self)
			)
			(4
				(glass dispose:)
				(shatteredGlass init: stopUpd: approachVerbs: 1 4 8)
				(SetFlag 38)
				(gEgo normalize: (if (== gAct 5) 426 else 831))
				(gEgo loop: 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		name {oriley}
		x 200
		y 240
		view 423
	)
)

(instance glass of Prop
	(properties
		name {glass}
		x 17
		y 161
		approachX 58
		approachY 164
		view 452
		loop 1
		priority 12
		signal 16400
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gMessager say: 4 1 (and (IsFlag 38) 2))
			)
			(4
				(cond
					((IsFlag 38)
						(gMessager say: 4 4 2)
					)
					((not (gCurRoom script:))
						(if (MuseumRgn nobodyAround:)
							(gCurRoom setScript: sBreakIt)
						else
							(return 1)
						)
					)
				)
			)
			(8
				(if (IsFlag 38)
					(gMessager say: 4 8 2)
				else
					(gMessager say: 4 8 1)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance shatteredGlass of View
	(properties
		name {shatteredGlass}
		x 17
		y 161
		noun 9
		view 454
		signal 16384
	)
)

(instance plaque of Feature
	(properties
		name {plaque}
		x 290
		y 78
		noun 12
		nsTop 69
		nsLeft 286
		nsBottom 87
		nsRight 295
		sightAngle 40
		approachX 277
		approachY 142
	)
)

(instance pyramid of Feature
	(properties
		name {pyramid}
		x 69
		y 142
		noun 5
		sightAngle 40
		onMeCheck 64
		approachX 78
		approachY 150
	)
)

(instance daggerCase of Feature
	(properties
		name {daggerCase}
		x 33
		y 168
		noun 4
		nsTop 142
		nsLeft 18
		nsBottom 167
		nsRight 48
		sightAngle 40
		approachX 58
		approachY 164
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gMessager say: 4 1 (and (IsFlag 38) 2))
			)
			(4
				(cond
					((IsFlag 38)
						(gMessager say: 4 4 2)
					)
					((not (gCurRoom script:))
						(if (MuseumRgn nobodyAround:)
							(gCurRoom setScript: sBreakIt)
						else
							(return 1)
						)
					)
				)
			)
			(8
				(if (IsFlag 38)
					(gMessager say: 4 8 2)
				else
					(gMessager say: 4 8 1)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance post of Feature
	(properties
		name {post}
		x 219
		y 148
		noun 2
		nsTop 25
		nsLeft 206
		nsBottom 146
		nsRight 232
		sightAngle 40
		approachX 213
		approachY 155
	)
)

(instance mummy of Feature
	(properties
		name {mummy}
		x 120
		y 176
		noun 1
		nsTop 97
		nsLeft 105
		nsBottom 176
		nsRight 136
		sightAngle 40
		approachX 164
		approachY 172
	)
)

(instance wallWindow of Feature
	(properties
		name {wallWindow}
		x 177
		y 80
		noun 3
		nsTop 58
		nsLeft 158
		nsBottom 102
		nsRight 197
		sightAngle 40
		approachX 179
		approachY 123
	)
)

(instance wings of Feature
	(properties
		name {wings}
		x 176
		y 45
		noun 6
		nsTop 36
		nsLeft 147
		nsBottom 54
		nsRight 205
		sightAngle 40
		approachX 180
		approachY 122
	)
)

(instance rock1 of Feature
	(properties
		name {rock1}
		x 76
		y 76
		noun 8
		nsTop 42
		nsLeft 22
		nsBottom 110
		nsRight 130
		sightAngle 40
		approachX 19
		approachY 125
	)
)

(instance rock2 of Feature
	(properties
		name {rock2}
		x 251
		y 79
		noun 7
		nsTop 42
		nsLeft 232
		nsBottom 116
		nsRight 270
		sightAngle 40
		approachX 251
		approachY 130
	)
)

(instance westExitFeature of ExitFeature
	(properties
		name {westExitFeature}
		nsTop 120
		nsBottom 169
		nsRight 5
		cursor 12
		exitDir 4
		noun 11
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
		noun 10
	)
)

(instance nGlass of Sound
	(properties
		name {nGlass}
		flags 5
		number 600
	)
)

(instance thudSound of Sound
	(properties
		name {thudSound}
		flags 5
		number 80
	)
)
