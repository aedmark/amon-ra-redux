;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use eRS)
(use n027)
(use Print)
(use Inset)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	local0
	local1
	local2
)

(instance rm250 of LBRoom
	(properties
		name {rm250}
		noun 14
		picture 250
	)

	(method (init &tmp [temp0 50])
		(LoadMany rsVIEW 250 251 252 253 254)
		(LoadMany rsSOUND 300 41 250 252)
		(noise number: 41 flags: 5 play:)
		(super init:)
		(proc0_8 1)
		(gWalkHandler addToFront: gCurRoom)
		(User canInput: 1)
		(laura cel: (if (gEgo wearingGown:) 1 else 0) addToPic:)
		(license init:)
		(if (and (TimeCheck $0001) (IsFlag 125) (not (IsFlag 27)))
			(trash1 init:)
			(trash2 init:)
			(trash3 init:)
			(trash4 init:)
			(trash5 init:)
			(cornerTrash addToPic:)
			(if
				(and
					(not (gEgo wearingGown:))
					(not (gEgo has: 1))
					(not (gEgo has: 32))
				)
				(ticket init:)
			)
			(DDriver addToPic:)
		else
			(CDriver addToPic:)
		)
		(gGameMusic1 number: 250)
		(win1 init: stopUpd:)
		(win2 init: stopUpd:)
		(win3 init: stopUpd:)
		(win4 init: stopUpd:)
		(win5 init: stopUpd:)
		(gNarrator y: 120)
		(cond
			((and (== gPrevRoomNum 300) (gEgo wearingGown:))
				(self setScript: sACTBREAK)
			)
			((not (gEgo has: 6))
				(if (gCast contains: trash1)
					(self setScript: sNoPressPassD)
				else
					(self setScript: sNoPressPassC)
				)
			)
			(else
				(self setScript: sHasPressPass)
			)
		)
	)

	(method (doVerb param1)
		(switch param1
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)

	(method (newRoom)
		(if inset
			(inset dispose:)
		)
		(gWalkHandler delete: gCurRoom)
		(if (gMessager talkerList:)
			(gMessager dispose:)
		)
		(proc0_8 0)
		(super newRoom: &rest)
	)
)

(instance sACTBREAK of Script
	(properties
		name {sACTBREAK}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gTheIconBar disable:)
				(proc27_2)
				((ScriptID 21 1) doit: 1029) ; dropCluesCode
				(win1 setCycle: Fwd)
				(win2 setCycle: Fwd)
				(win3 setCycle: Fwd)
				(win4 setCycle: Fwd)
				(win5 setCycle: Fwd)
				(gGameMusic2 send: 2 224 2400)
				(= cycles 1)
			)
			(1
				(gGameMusic2 send: 2 224 2800)
				(= cycles 1)
			)
			(2
				(gGameMusic2 send: 2 224 3200)
				(= cycles 1)
			)
			(3
				(gGameMusic2 send: 2 224 3600)
				(= cycles 1)
			)
			(4
				(gGameMusic2 send: 2 224 4000)
				(gGameMusic1 number: 300 loop: 1 flags: 1 play: self)
			)
			(5
				(gGameMusic2 send: 2 224 3000)
				(= cycles 1)
			)
			(6
				(gGameMusic2 send: 2 224 2000)
				(= cycles 1)
			)
			(7
				(gGameMusic2 send: 2 224 1000)
				(= cycles 1)
			)
			(8
				(gGameMusic2 send: 2 224 500)
				(= cycles 1)
			)
			(9
				(gGameMusic2 send: 2 224 0)
				(= cycles 5)
			)
			(10
				(gGameMusic1 fade:)
				(gGameMusic2 fade:)
				(gCurRoom newRoom: 26)
			)
		)
	)
)

(instance sNoPressPassD of Script
	(properties
		name {sNoPressPassD}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 9 1 self)
			)
			(2
				(gMessager say: 1 0 10 1 self)
			)
			(3
				(gMessager say: 1 0 9 2 self)
			)
			(4
				(gGame handsOn:)
				(= seconds 15)
			)
			(5
				(gMessager say: 1 0 9 3 self)
			)
			(6
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
		)
	)
)

(instance sNoPressPassC of Script
	(properties
		name {sNoPressPassC}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 1 1 self)
			)
			(2
				(gMessager say: 1 0 10 1 self)
			)
			(3
				(gMessager say: 1 0 1 2 self)
			)
			(4
				(gGame handsOn:)
				(= seconds 15)
			)
			(5
				(gMessager say: 1 0 1 3 self)
			)
			(6
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
		)
	)
)

(instance sHasPressPass of Script
	(properties
		name {sHasPressPass}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= register 0)
				(= cycles 1)
			)
			(1
				(cond
					((and (gCast contains: trash1) (not (IsFlag 26)))
						(client setScript: s1stTimeInDirtyTaxi self)
					)
					((gCast contains: trash1)
						(gMessager say: 1 0 7 6 self)
					)
					; PLAY-002: flag 125 means Rocco has already seen her press pass.
					((IsFlag 125)
						(= register 1)
						(gMessager say: 1 0 11 1 self)
					)
					((not (gCast contains: trash1))
						(gMessager say: 1 0 8 0 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if register
					(client setScript: sWhereToBud)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s1stTimeInDirtyTaxi of Script
	(properties
		name {s1stTimeInDirtyTaxi}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 7 1 self)
			)
			(2
				(gMessager say: 1 0 7 2 self)
				(SetFlag 26)
			)
			(3
				(= register 0)
				(switch
					(Print
						addText: 16 0 0 0
						addButton: 1 15 0 0 1 5 18
						addButton: 2 15 0 0 2 5 48
						init:
					)
					(1
						(gMessager say: 1 0 7 6 self)
					)
					(2
						(gMessager say: 1 0 7 5 self)
						(= register 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(= seconds 1)
			)
			(5
				(if (== register 1)
					(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
				else
					(= cycles 1)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWhereToBud of Script
	(properties
		name {sWhereToBud}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(if (not (gCast contains: trash1))
					(gMessager say: 5 11 8 0 self)
				else
					(gMessager say: 4 11 7 0 self)
				)
			)
			(2
				(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
					(513
						(= local0 210)
					)
					(515
						(= local0 260)
					)
					(516
						(= local0 240)
					)
					(514
						(= local0 280)
					)
					(518
						(= local0 300)
					)
					(520
						(= local0 300)
					)
					(517
						(= local0 330)
					)
					(519
						(= local2 1)
						(= local0 250)
						(if (not (gCast contains: trash1))
							(gMessager say: 17 14 8 0)
						else
							(gMessager say: 17 14 7 0)
						)
					)
					(-1
						(= local0 250)
					)
					(else
						(= local0 250)
						(if (not (gCast contains: trash1))
							(gMessager say: 12 14 8 0)
						else
							(gMessager say: 12 14 7 0)
						)
					)
				)
				(= cycles 1)
			)
			(3
				(cond
					((or (== local0 gPrevRoomNum) (== local0 gCurRoomNum))
						(gGame handsOn:)
						(= cycles 1)
					)
					((not (gCast contains: trash1))
						(self setScript: sDoTakeOffFlight self)
					)
					(else
						(self setScript: sMoveBuildings self)
					)
				)
			)
			(4
				(gTheIconBar enable: 5)
				(if (!= local0 gCurRoomNum)
					(gCurRoom newRoom: local0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoTakeOffFlight of Script
	(properties
		name {sDoTakeOffFlight}
	)

	(method (doit)
		(if
			(and
				(== (self state:) 9)
				(== (gGameMusic1 number:) 250)
				(== (gGameMusic1 prevSignal:) -1)
			)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState param1 &tmp [temp0 50])
		(switch (= state param1)
			(0
				(SetFlag 125)
				(gGame handsOff:)
				(User canInput: 1)
				(= cycles 1)
			)
			(1
				(win1 setCycle: Fwd)
				(win2 setCycle: Fwd)
				(win3 setCycle: Fwd)
				(win4 setCycle: Fwd)
				(win5 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(gGameMusic1 number: 250 loop: 1 flags: 1 play:)
				(gGame handsOn:)
				(gTheIconBar disable: 5 6 0)
				(= cycles 1)
			)
			(3
				(gGameMusic2 send: 2 224 1000)
				(= cycles 1)
			)
			(4
				(gGameMusic2 send: 2 224 2000)
				(= cycles 1)
			)
			(5
				(gGameMusic2 send: 2 224 3000)
				(= cycles 1)
			)
			(6
				(gGameMusic2 send: 2 224 4000)
				((ScriptID 1902 13) modeless: 1) ; Rocco
				((ScriptID 1903 14) modeless: 1) ; Bob
				(= register (Random 11 17))
				(cond
					((== register 17)
						(= seconds 8)
					)
					((== register 16)
						(= seconds 8)
					)
					(else
						(gMessager say: 10 0 register 0 self)
					)
				)
			)
			(7
				(gGameMusic2 send: 2 224 3000)
				(= cycles 1)
			)
			(8
				(gGameMusic2 send: 2 224 2000)
				(= cycles 1)
			)
			(9 0)
			(10
				(win1 setCycle: 0)
				(win2 setCycle: 0)
				(win3 setCycle: 0)
				(win4 setCycle: 0)
				(win5 setCycle: 0)
				(gGameMusic2 send: 2 224 1000)
				(if (== register 16)
					(gMessager say: 10 0 16 0 self)
				else
					(= register 0)
					(= cycles 1)
				)
			)
			(11
				(gGameMusic2 send: 2 224 500)
				(= cycles 1)
			)
			(12
				(gGameMusic2 send: 2 224 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMoveBuildings of Script
	(properties
		name {sMoveBuildings}
	)

	(method (doit)
		(if
			(and
				(== (self state:) 6)
				(== (gGameMusic1 number:) 250)
				(== (gGameMusic1 prevSignal:) -1)
			)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(win1 setCycle: Fwd)
				(win2 setCycle: Fwd)
				(win3 setCycle: Fwd)
				(win4 setCycle: Fwd)
				(win5 setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(gGameMusic1 number: 250 loop: 1 flags: 1 play:)
				(gGame handsOn:)
				(gTheIconBar disable: 5 6 0)
				(= cycles 1)
			)
			(2
				(gGameMusic2 send: 2 224 1000)
				(= cycles 1)
			)
			(3
				(gGameMusic2 send: 2 224 2000)
				(= cycles 1)
			)
			(4
				(gGameMusic2 send: 2 224 3000)
				(= cycles 1)
			)
			(5
				(gGameMusic2 send: 2 224 4000)
				(= seconds (Random 6 10))
			)
			(6 0)
			(7
				(self dispose:)
				(gGameMusic1 fade:)
			)
		)
	)
)

(instance laura of View
	(properties
		name {laura}
		y 100
		z 75
		view 251
		priority 10
		signal 4113
	)

	(method (doVerb param1)
		(if (== param1 13)
			(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
		else
			(gEgo doVerb: param1 &rest)
		)
	)
)

(instance DDriver of View
	(properties
		name {DDriver}
		x 232
		y 104
		noun 4
		view 252
		loop 1
		priority 4
		signal 6161
	)

	(method (doVerb param1 &tmp temp0)
		(switch param1
			(1
				(gMessager say: 4 1 7 0)
			)
			(4
				(gMessager say: 4 4 7 0)
			)
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(6
				(cond
					(local2
						(gCurRoom setScript: sWhereToBud)
					)
					(
						(and
							(<=
								512
								(= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
							)
							(<= temp0 665)
						)
						(gMessager say: 11 6 7 0)
					)
					(else
						(gMessager say: 12 6 7 0)
					)
				)
			)
			(2
				(gMessager say: 4 2 7 0)
			)
			(11
				(gCurRoom setScript: sWhereToBud)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance CDriver of View
	(properties
		name {CDriver}
		x 232
		y 104
		noun 5
		view 252
		priority 4
		signal 6161
	)

	(method (doVerb param1 &tmp temp0)
		(switch param1
			(1
				(gMessager say: 5 1 8 0)
			)
			(4
				(gMessager say: 5 4 8 0)
			)
			(6
				(cond
					(local2
						(gCurRoom setScript: sWhereToBud)
					)
					(
						(and
							(<=
								512
								(= temp0 (gCurRoom setInset: (ScriptID 20 0))) ; inNotebook
							)
							(<= temp0 665)
						)
						(gMessager say: 11 6 8 0)
					)
					(else
						(gMessager say: 12 6 8 0)
					)
				)
			)
			(2
				(gMessager say: 5 2 8 0)
			)
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(11
				(gCurRoom setScript: sWhereToBud)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance win1 of Prop
	(properties
		name {win1}
		x 87
		y 96
		noun 6
		view 253
		priority 2
		signal 17
		cycleSpeed 7
	)

	(method (doVerb param1)
		(switch param1
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance win2 of Prop
	(properties
		name {win2}
		x 141
		y 97
		noun 6
		view 253
		loop 1
		priority 2
		signal 16401
		cycleSpeed 7
	)

	(method (doVerb param1)
		(switch param1
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance win3 of Prop
	(properties
		name {win3}
		x 159
		y 92
		noun 6
		view 254
		priority 2
		signal 17
		cycleSpeed 7
	)

	(method (doVerb param1)
		(switch param1
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance win4 of Prop
	(properties
		name {win4}
		x 213
		y 88
		noun 6
		view 254
		loop 1
		priority 2
		signal 17
		cycleSpeed 7
	)

	(method (doVerb param1)
		(switch param1
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance win5 of Prop
	(properties
		name {win5}
		x 268
		y 89
		noun 6
		view 254
		loop 2
		priority 2
		signal 17
		cycleSpeed 7
	)

	(method (doVerb param1)
		(switch param1
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance inTicket of Inset
	(properties
		name {inTicket}
		view 250
		x 190
		y 154
		disposeNotOnMe 1
		noun 9
	)

	(method (doVerb param1)
		(switch param1
			(4
				((ScriptID 21 0) doit: 770) ; addCluesCode
				(ticket dispose:)
				(inTicket dispose:)
				(gEgo get: -1 1)
				(SetFlag 27)
			)
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance ticket of View
	(properties
		name {ticket}
		x 149
		y 178
		view 250
		loop 2
		priority 8
		signal 16
	)

	(method (doVerb param1 param2)
		(switch param1
			(1
				(gCurRoom setInset: inTicket)
			)
			(4
				(gEgo get: 1)
				(SetFlag 27)
				((ScriptID 21 0) doit: 770) ; addCluesCode
				(self dispose:)
			)
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: param1 param2 &rest)
			)
		)
	)
)

(instance license of Feature
	(properties
		name {license}
		x 246
		y 114
		nsTop 99
		nsLeft 219
		nsBottom 130
		nsRight 274
		sightAngle 40
	)

	(method (doVerb param1)
		(if (gCast contains: trash1)
			(= noun 7)
		else
			(= noun 8)
		)
		(switch param1
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(class Trash of View
	(properties
		name {Trash}
		noun 2
		view 250
		loop 1
		boundryLeft 0
		boundryRight 319
		boundryTop 155
		boundryBottom 189
	)

	(method (init)
		(if (and (TimeCheck $0001) (IsFlag 125) (not (IsFlag 27)))
			(gMouseDownHandler addToFront: self)
			(gKeyDownHandler addToFront: self)
		)
		(super init: &rest)
	)

	(method (doit)
		(if (and (== local1 self) (self inBounds:))
			(= x gMouseX)
			(= y gMouseY)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent param1)
		(cond
			(
				(and
					(== (param1 message:) 13)
					(== (param1 type:) 4)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					(self onMe: param1)
				)
				(if (!= local1 self)
					(= local1 self)
					(noise number: 54 loop: 1 flags: 5 play:)
				else
					(= local1 0)
				)
				(param1 claimed: 1)
			)
			(
				(and
					(== (param1 type:) 1)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					(self onMe: param1)
				)
				(noise number: 54 loop: 1 flags: 5 play:)
				(= local1 self)
				(param1 claimed: 1)
			)
			((and (== (param1 type:) 2) (self onMe: param1))
				(= local1 0)
				(param1 claimed: 1)
			)
			(else
				(super handleEvent: param1 &rest)
			)
		)
	)

	(method (doVerb param1)
		(switch param1
			(13
				(gCurRoom newRoom: (if gPrevRoomNum gPrevRoomNum else 210))
			)
			(1
				(gMessager say: 3 1 4)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)

	(method (inBounds)
		(return
			(and
				(> gMouseX boundryLeft)
				(< gMouseX boundryRight)
				(> gMouseY boundryTop)
				(< gMouseY boundryBottom)
			)
		)
	)
)

(instance trash1 of Trash
	(properties
		name {trash1}
		x 166
		y 176
		cel 2
		signal 16384
	)
)

(instance trash2 of Trash
	(properties
		name {trash2}
		x 145
		y 163
		cel 3
		signal 16384
	)
)

(instance trash3 of Trash
	(properties
		name {trash3}
		x 148
		y 181
		cel 4
		signal 16384
	)
)

(instance trash4 of Trash
	(properties
		name {trash4}
		x 112
		y 174
		cel 5
		signal 16384
	)
)

(instance trash5 of Trash
	(properties
		name {trash5}
		x 58
		y 174
		signal 16384
	)
)

(instance cornerTrash of View
	(properties
		name {cornerTrash}
		x 261
		y 189
		noun 2
		view 250
		loop 3
		priority 1
		signal 2064
	)

	(method (doVerb param1)
		(switch param1
			(4
				(cond
					((IsFlag 27)
						(gMessager say: 2 4 4)
					)
					((and (TimeCheck $0001) (IsFlag 125) (not (IsFlag 27)))
						(gMessager say: 2 4 2)
					)
					((gEgo wearingGown:)
						(gMessager say: 2 4 4)
					)
					((gEgo has: 0)
						(gMessager say: 2 4 4)
					)
					(else
						(gMessager say: 2 4 4)
					)
				)
			)
			(1
				(gMessager say: 3 1 4)
			)
			(else
				(super doVerb: param1 &rest)
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
