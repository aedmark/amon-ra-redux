;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
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
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm290 0
	theWanderer 38
)

(local
	local0
	local1 = 1
	local2
)

(instance rm290 of LBRoom
	(properties
		name {rm290}
		noun 15
		picture 290
		north 295
		south 280
	)

	(method (init)
		(LoadMany rsVIEW 290 291 293 292)
		(LoadMany rsSOUND 292 280)
		(gEgo init: normalize: 830 setScale: Scaler 137 0 190 0)
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: 0 setHeading: 180)
			)
			(south
				(gEgo posn: 160 230)
				(gCurRoom setScript: sComeInSouth)
			)
			(else
				(gEgo posn: 140 173)
				(gGame handsOn:)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						308
						144
						281
						145
						273
						146
						261
						152
						236
						157
						199
						157
						197
						164
						175
						169
						27
						137
						27
						129
						96
						124
						97
						117
						44
						118
						28
						81
						27
						120
						11
						123
						0
						189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 64 189 85 171 107 189
					yourself:
				)
		)
		(officeDoor init: locked: (IsFlag 43))
		(happyWanderer init: setScript: sWander)
		(sergeant init: approachVerbs: 1 6 2 4 7 8 setScript: sMoveSergeant)
		(southExitFeature init:)
		(southExitFeature2 init:)
		(files init:)
		(desk init:)
		(poster1 init:)
		(poster2 init:)
		(poster3 init:)
		(poster4 init:)
		(poster5 init:)
		(poster6 init:)
		(pole init:)
	)

	(method (doit)
		(cond
			(script)
			((StepOn gEgo 16)
				(self setScript: sEgoLeaveSouth)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
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
				(gEgo setMotion: MoveFwd 80 self)
			)
			(2
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance sComeInSouth of Script
	(properties
		name {sComeInSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 160 175 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKnock of Script
	(properties
		name {sKnock}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(knockSound play: self)
			)
			(1
				(gMessager say: 3 4 0 0 self)
			)
			(2
				(= local2 1)
				(officeDoor doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance sMoveSergeant of Script
	(properties
		name {sMoveSergeant}
	)

	(method (doit)
		(if (and (not local0) (sergeant cycler:) (== (sergeant cel:) 3))
			(shuffleSound play: sergeant)
			(= local0 1)
		)
		(super doit:)
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(sergeant setCycle: Fwd)
				(= seconds (Random 1 6))
			)
			(1
				(sergeant setCycle: 0)
				(= seconds (Random 2 4))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sGiveSandwich of Script
	(properties
		name {sGiveSandwich}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 252 152 self)
			)
			(1
				(Face gEgo sergeant self)
			)
			(2
				(sergeant setScript: 0)
				(sergeant loop: 1 cel: 0 cycleSpeed: 10 setCycle: CT 8 1 self)
				(gEgo
					view: 292
					posn: 240 152
					loop: 1
					cel: 0
					cycleSpeed: 10
					setCycle: CT 4 1 self
				)
			)
			(3
				(gMessager say: 2 15)
			)
			(4
				(gEgo setCycle: End self)
				(sergeant setCycle: End self)
			)
			(5 0)
			(6
				(sergeant loop: 0 setScript: sMoveSergeant)
				(SetFlag 7)
				((ScriptID 21 1) doit: 772) ; dropCluesCode
				(gEgo put: 3)
				(gEgo normalize: 830)
				(gEgo loop: 7 posn: 254 152 setHeading: 315)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWander of Script
	(properties
		name {sWander}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= seconds (Random 3 20))
			)
			(1
				(client setCycle: Walk setMotion: MoveTo 154 122 self)
			)
			(2
				(= ticks (Random 30 240))
			)
			(3
				(client setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(client setLoop: 1 setCycle: Walk setMotion: MoveTo -20 141 self)
			)
			(5
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance happyWanderer of Actor
	(properties
		name {happyWanderer}
		x -20
		y 141
		noun 1
		view 293
		signal 4096
	)
)

(instance sergeant of Prop
	(properties
		name {sergeant}
		x 220
		y 116
		noun 2
		approachX 254
		approachY 152
		view 291
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(switch param1
			(15
				(gCurRoom setScript: sGiveSandwich)
			)
			(2
				(cond
					((IsFlag 7)
						(= temp1 73)
					)
					(local1
						(= temp1 78)
					)
					(else
						(= temp1 79)
					)
				)
				(gMessager say: 2 2 temp1)
				(= local1 0)
			)
			(6
				(if (not (IsFlag 7))
					(gMessager say: 2 6 70)
				else
					(if
						(==
							(= temp0
								(if (== argc 2)
									param2
								else
									(= global178 5) ; PLAY-008: bit 4 marks topics Sgt. O'Flaherty has answered
									(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
								)
							)
							-1
						)
						(return)
					)
					(= temp2 (& temp0 $00ff))
					(= temp1
						(switch (& temp0 $ff00)
							(256
								(+ temp2 1)
							)
							(512
								(+ temp2 18)
							)
							(768
								(+ temp2 26)
							)
							(1024
								(+ temp2 61)
							)
						)
					)
					(switch temp0
						(260
							(if (officeDoor locked:)
								(gMessager say: 2 6 71)
							else
								(gMessager say: 2 6 5)
							)
						)
						(520
							(gMessager say: 2 6 26)
							((ScriptID 21 0) doit: 1029) ; addCluesCode
						)
						(264
							(gMessager say: 2 6 9)
							((ScriptID 21 1) doit: 518) ; dropCluesCode
							((ScriptID 21 0) doit: 520) ; addCluesCode
						)
						(else
							(if (Message msgGET gCurRoomNum noun 6 temp1 1)
								(gMessager say: noun 6 temp1)
							else
								(gMessager say: noun 6 43)
							)
						)
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)

	(method (cue)
		(= local0 0)
		(super cue:)
	)
)

(instance officeDoor of Door
	(properties
		name {officeDoor}
		x 18
		y 57
		noun 3
		approachX 58
		approachY 125
		view 290
		entranceTo 295
		moveToX 37
		moveToY 110
		enterType 0
		exitType 0
	)

	(method (doVerb param1)
		(switch param1
			(4
				(cond
					(local2
						(super doVerb: param1 &rest)
					)
					((not (self locked:))
						(gEgo setScript: sKnock)
					)
					(else
						(Face gEgo officeDoor)
						(super doVerb: param1 &rest)
					)
				)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)

	(method (createPoly)
		(super createPoly: 12 112 55 112 54 121 15 122)
	)
)

(instance theWanderer of Narrator
	(properties
		name {theWanderer}
		back 15
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance files of Feature
	(properties
		name {files}
		y 2
		noun 4
		nsTop 76
		nsLeft 150
		nsBottom 98
		nsRight 204
	)
)

(instance desk of Feature
	(properties
		name {desk}
		y 1
		noun 5
		nsTop 98
		nsLeft 58
		nsBottom 151
		nsRight 261
	)
)

(instance poster1 of Feature
	(properties
		name {poster1}
		y 189
		noun 6
		nsTop 34
		nsLeft 75
		nsBottom 55
		nsRight 100
	)
)

(instance poster2 of Feature
	(properties
		name {poster2}
		y 189
		noun 7
		nsTop 64
		nsLeft 84
		nsBottom 79
		nsRight 101
	)

	(method (doVerb param1 param2)
		(switch param1
			(4
				(poster1 doVerb: 4)
			)
			(else
				(super doVerb: param1 param2 &rest)
			)
		)
	)
)

(instance poster3 of Feature
	(properties
		name {poster3}
		y 189
		noun 8
		nsTop 66
		nsLeft 69
		nsBottom 85
		nsRight 79
	)

	(method (doVerb param1 param2)
		(switch param1
			(4
				(poster1 doVerb: 4)
			)
			(else
				(super doVerb: param1 param2 &rest)
			)
		)
	)
)

(instance poster4 of Feature
	(properties
		name {poster4}
		y 189
		noun 9
		nsTop 85
		nsLeft 74
		nsBottom 106
		nsRight 81
	)

	(method (doVerb param1 param2)
		(switch param1
			(4
				(poster1 doVerb: 4)
			)
			(else
				(super doVerb: param1 param2 &rest)
			)
		)
	)
)

(instance poster5 of Feature
	(properties
		name {poster5}
		y 189
		noun 10
		nsTop 100
		nsLeft 84
		nsBottom 114
		nsRight 94
	)

	(method (doVerb param1 param2)
		(switch param1
			(4
				(poster1 doVerb: 4)
			)
			(else
				(super doVerb: param1 param2 &rest)
			)
		)
	)
)

(instance poster6 of Feature
	(properties
		name {poster6}
		y 189
		noun 11
		nsTop 117
		nsLeft 69
		nsBottom 137
		nsRight 95
	)

	(method (doVerb param1 param2)
		(switch param1
			(4
				(poster1 doVerb: 4)
			)
			(else
				(super doVerb: param1 param2 &rest)
			)
		)
	)
)

(instance pole of Feature
	(properties
		name {pole}
		y 188
		noun 12
		nsLeft 71
		nsBottom 189
		nsRight 100
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsLeft 111
		nsBottom 189
		nsRight 320
		cursor 11
		exitDir 3
		noun 14
	)
)

(instance southExitFeature2 of ExitFeature
	(properties
		name {southExitFeature2}
		nsTop 184
		nsBottom 189
		nsRight 63
		cursor 11
		exitDir 3
		noun 14
	)
)

(instance shuffleSound of Sound
	(properties
		name {shuffleSound}
		flags 5
		number 292
	)
)

(instance knockSound of Sound
	(properties
		name {knockSound}
		flags 1
		number 297
	)
)
