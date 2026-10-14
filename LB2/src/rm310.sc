;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
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
(use Motion)
(use Actor)
(use System)

(public
	rm310 0
	Bartender 22
	PianoPlayer 30
	Singer 31
)

(local
	local0 = 1
	local1 = 1
	local2 = 1
	local3 = 1
)

(procedure (localproc_0 &tmp temp0)
	(switch (= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
		(1026
			(gMessager say: 1 6 28)
		)
		(1027
			(gMessager say: 1 6 30)
		)
		(259
			(gMessager say: 1 6 17)
		)
		(1029
			(gMessager say: 1 6 12)
		)
		(261
			(gMessager say: 1 6 9)
		)
		(780
			(gMessager say: 1 6 20)
		)
		(516
			(gMessager say: 1 6 24)
		)
		(1028
			((ScriptID 21 0) doit: 268) ; addCluesCode
			(gMessager say: 1 6 31)
		)
		(262
			(gMessager say: 1 6 15)
		)
		(518
			(gMessager say: 1 6 35)
		)
		(517
			(gMessager say: 1 6 19)
		)
		(519
			(gMessager say: 1 6 29)
		)
		(513
			(gMessager say: 1 6 23)
		)
		(260
			(gMessager say: 1 6 13)
		)
		(258
			(gMessager say: 1 6 16)
		)
		(514
			(gMessager say: 1 6 22)
		)
		(268
			(gMessager say: 1 6 27)
		)
		(520
			(gMessager say: 1 6 35)
		)
		(263
			(gMessager say: 1 6 14)
		)
		(264
			(gMessager say: 1 6 3)
		)
		(266
			(gMessager say: 1 6 36)
		)
		(269
			(gMessager say: 1 6 37)
		)
		(-1 0)
		(else
			(cond
				((<= 256 temp0 409)
					(gMessager say: 1 6 18)
				)
				((<= 768 temp0 921)
					(gMessager say: 1 6 26)
				)
				(else
					(gMessager say: 1 6 21)
				)
			)
		)
	)
)

(instance rm310 of LBRoom
	(properties
		name {rm310}
		noun 13
		picture 310
		north 320
		south 300
		vanishingX 167
		vanishingY -20
	)

	(method (init &tmp [temp0 3] temp3 [temp4 30])
		(LoadMany rsVIEW 311 317 312 313 314 315 318 831 830)
		(LoadMany rsSOUND 310 311 312 314)
		(gEgo
			setScale: Scaler 137 0 190 -20
			init:
			normalize: (if (gEgo wearingGown:) 831 else 830)
		)
		(= temp3 (if (== (DoSound sndGET_POLYPHONY) 32) 310 else 314))
		(switch gPrevRoomNum
			(north
				(gEgo x: 236 y: 107 edgeHit: 0 setHeading: 180)
				(gGameMusic1 setVol: 127)
				(gGameMusic2 stop:)
			)
			(south
				(gEgo x: 195)
			)
			(else
				(gEgo posn: 160 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(LoadMany rsVIEW 311 317 312 313 314 315 318 831 830)
		(LoadMany rsSOUND 310 311 312 314)
		(if (!= gPrevRoomNum north)
			(switch (Random 0 2)
				(0
					(WrapMusic init: 1 temp3 311 1312)
				)
				(1
					(WrapMusic init: 1 311 temp3 1312)
				)
				(2
					(WrapMusic init: 1 1312 temp3 311)
				)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						26
						189
						0
						189
						0
						0
						319
						0
						319
						189
						287
						189
						238
						172
						201
						118
						245
						111
						245
						97
						274
						92
						258
						69
						219
						108
						193
						112
						174
						115
						168
						127
						119
						122
						85
						152
					yourself:
				)
		)
		(bartender approachVerbs: 1 2 6 addToPic:)
		(barfly1 addToPic:)
		(barfly2 addToPic:)
		(ziggy approachVerbs: 1 2 6 init: setScript: sZiggySmokes)
		(woman2 addToPic:)
		(dancersA init: setScript: sRDancers)
		(dancersB init: setScript: sMDancers)
		(dancersC setCycle: Fwd init:)
		(flapper setCycle: Fwd init:)
		(pianoplayer init: setCycle: Fwd)
		(sleeper addToPic:)
		(woman1 addToPic:)
		(bathroomDoor init:)
		(endOfBar init:)
		(southExitFeature init:)
		((ScriptID 1881 2) ; Laura
			x: 5
			y: 95
			textX: 120
			textY: 20
			talkWidth: 120
		)
	)

	(method (newRoom param1)
		(if (== param1 320)
			(gGameMusic1 fade: 80 10 12 0)
		else
			(Actions dispose:)
		)
		(super newRoom: param1)
	)
)

(instance sRDancers of Script
	(properties
		name {sRDancers}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(dancersA view: 313 loop: 0 setCycle: Fwd)
				(= seconds (Random 5 10))
			)
			(1
				(dancersA view: 313 loop: 1 setCycle: Fwd)
				(= seconds (Random 4 6))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sMDancers of Script
	(properties
		name {sMDancers}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(dancersB view: 313 loop: 2 setCycle: Fwd)
				(= seconds (Random 4 7))
			)
			(1
				(dancersB view: 314 loop: 2 setCycle: End self)
			)
			(2
				(dancersB view: 313 loop: 3 setCycle: Fwd)
				(= seconds (Random 4 8))
			)
			(3
				(dancersB view: 314 loop: 2 cel: 11 setCycle: Beg self)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sBartender of Script ; UNUSED
	(properties
		name {sBartender}
	)

	(method (changeState param1 &tmp target)
		(= target bartender)
		(switch (= state param1)
			(0
				(bartender setLoop: 2)
				(= seconds (Random 9 19))
			)
			(1
				(switch (Random 0 1)
					(0
						(target setLoop: 1 setMotion: MoveTo 55 113 self)
					)
					(1
						(target setLoop: 0 setMotion: MoveTo 7 123 self)
					)
				)
			)
			(2
				(if (> (bartender x:) 10)
					(bartender setLoop: 0)
				else
					(bartender setLoop: 1)
				)
				(target setMotion: MoveTo 47 115 self)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sZiggySmokes of Script
	(properties
		name {sZiggySmokes}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(ziggy setCycle: End self)
			)
			(1
				(= seconds (Random 1 6))
			)
			(2
				(switch (Random 0 2)
					(0
						(= cycles 1)
					)
					(else
						(ziggy cel: 3 setCycle: End self)
					)
				)
			)
			(3
				(ziggy cel: 3 setCycle: CT 0 -1 self)
			)
			(4
				(= seconds (Random 2 4))
			)
			(5
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sNodder of Script ; UNUSED
	(properties
		name {sNodder}
	)

	(method (changeState param1 &tmp target)
		(= target woman2)
		(switch (= state param1)
			(0
				(target setCycle: End self)
			)
			(1
				(= cycles (Random 1 10))
			)
			(2
				(target setCycle: Beg self)
			)
			(3
				(= cycles (Random 10 20))
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sWhoSentYa of Script
	(properties
		name {sWhoSentYa}
	)

	(method (changeState param1 &tmp temp0)
		(switch (= state param1)
			(0
				(gMessager say: 1 2 6 0 self)
				(= local1 0)
				((ScriptID 22 0) doit: 8) ; triggerAndClock
				(gGame points: 1 131)
			)
			(1
				(switch (= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
					(261
						(gMessager say: 1 2 8 0 self)
						(SetFlag 118)
					)
					(else
						(if (<= 256 temp0 409)
							(gMessager say: 1 2 7 0 self)
						else
							(gMessager say: 1 6 21 0 self)
						)
						(ClearFlag 118)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sLeaveSouth of Script
	(properties
		name {sLeaveSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath gMouseX 190 self)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) 270 self)
			)
			(3
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance bartender of View
	(properties
		name {bartender}
		x 47
		y 115
		noun 2
		approachX 113
		approachY 129
		view 312
		loop 2
	)

	(method (doVerb param1)
		(switch param1
			(6
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(264
						(gMessager say: 2 6 3 0)
					)
					(-1 0)
					(else
						(gMessager say: 2 6 4 0)
					)
				)
			)
			(2
				(gMessager say: 2 2 0 0)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance barfly1 of View
	(properties
		name {barfly1}
		x 59
		y 148
		noun 3
		view 312
		loop 3
		priority 10
		signal 16
	)
)

(instance barfly2 of View
	(properties
		name {barfly2}
		x 81
		y 140
		noun 10
		view 312
		loop 4
		priority 10
		signal 16
	)
)

(instance ziggy of Prop
	(properties
		name {ziggy}
		x 292
		y 124
		noun 1
		approachX 232
		approachY 157
		view 318
		cel 5
		priority 12
		signal 4112
	)

	(method (doVerb param1 &tmp temp0)
		(switch param1
			(6
				(cond
					((and (TimeCheck $0008 0) (IsFlag 118))
						(localproc_0)
					)
					(local1
						(gMessager say: 1 2 33 2)
					)
					((IsFlag 118)
						(localproc_0)
					)
					(else
						(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
							(261
								(gMessager say: 1 6 9 0)
								(SetFlag 118)
							)
							(else
								(gMessager say: 1 6 21 0)
							)
						)
					)
				)
			)
			(2
				(cond
					((TimeCheck $0008 0)
						(gMessager say: 1 2 32)
					)
					(local1
						(gCurRoom setScript: sWhoSentYa)
					)
					(local2
						(if (IsFlag 118)
							(gMessager say: 1 2 32)
						else
							(gMessager say: 1 2 33)
						)
						(= local2 0)
					)
					(local3
						(if (IsFlag 118)
							(gMessager say: 1 2 34)
						else
							(gMessager say: 1 2 33)
						)
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance flapper of Prop
	(properties
		name {flapper}
		x 141
		y 87
		noun 4
		view 315
		cel 1
	)

	(method (doVerb param1)
		(switch param1
			(6
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(-1 0)
					(else
						(gMessager say: 4 6 5)
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance pianoplayer of Prop
	(properties
		name {pianoplayer}
		x 116
		y 83
		noun 5
		view 315
		loop 1
		cel 13
	)

	(method (doVerb param1)
		(switch param1
			(6
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(-1 0)
					(else
						(gMessager say: 5 6 5)
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance sleeper of View
	(properties
		name {sleeper}
		x 287
		y 117
		noun 6
		view 317
		loop 1
		cel 3
	)
)

(instance woman1 of View
	(properties
		name {woman1}
		x 261
		y 100
		noun 11
		view 317
		cel 3
		priority 8
		signal 16
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if local0
					(gMessager say: 11 1 1)
					(= local0 0)
				else
					(gMessager say: 11 1 2)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance woman2 of View
	(properties
		name {woman2}
		x 236
		y 101
		noun 11
		view 317
		loop 2
		priority 8
		signal 16400
	)

	(method (doVerb param1)
		(woman1 doVerb: param1)
	)
)

(instance dancersA of Prop
	(properties
		name {dancersA}
		x 183
		y 111
		noun 8
		view 313
		cel 1
		signal 4096
	)
)

(instance dancersB of Prop
	(properties
		name {dancersB}
		x 151
		y 121
		noun 8
		view 313
		loop 3
		cel 5
		signal 4096
	)
)

(instance dancersC of Prop
	(properties
		name {dancersC}
		x 106
		y 114
		noun 8
		view 313
		loop 4
		cel 2
	)
)

(instance bathroomDoor of Door
	(properties
		name {bathroomDoor}
		x 215
		y 51
		noun 9
		approachX 228
		approachY 109
		view 311
		entranceTo 320
		moveToX 255
		moveToY 95
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 211 100 253 100 253 109 211 109)
	)
)

(instance endOfBar of Feature
	(properties
		name {endOfBar}
		y 136
		nsTop 99
		nsLeft 90
		nsBottom 131
		nsRight 110
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 12
	)

	(method (handleEvent param1)
		(cond
			((not (gUser input:)))
			((not (self onMe: gMouseX (- gMouseY 10))))
			(
				(or
					(and (== (param1 type:) 4) (!= (param1 message:) 13))
					(and (== (param1 type:) 1) (param1 modifiers:))
					(not (OneOf (param1 type:) 1 4))
				)
				(= lastCursor -1)
			)
			((== gTheCursor ((gTheIconBar at: 1) cursor:))
				(param1 claimed: 1)
				(gMessager say: noun 1)
			)
			((!= gTheCursor cursor))
			(else
				(param1 claimed: 1)
				(gCurRoom setScript: sLeaveSouth)
			)
		)
	)
)

(instance Bartender of Narrator
	(properties
		name {Bartender}
		x 100
		y 100
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance Singer of Narrator
	(properties
		name {Singer}
		x 100
		y 100
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance PianoPlayer of Narrator
	(properties
		name {PianoPlayer}
		x 100
		y 100
		talkWidth 150
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)
