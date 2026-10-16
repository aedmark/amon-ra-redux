;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use Scaler)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm610 0
	northDoor 1
	eastDoor 2
)

(local
	local0 = -1
	local1 = 195
	local2 = 200
	local3 = 208
	local4 = 216
	local5 = 234
	local6 = 172
	local7 = 167
	local8 = 161
	local9 = 148
	local10 = 129
	local11 = 79
	local12 = 64
	local13 = 46
	local14 = 23
	[local15 15] = [-1 132 136 145 151 150 127 132 136 144 154 138 139 143 150]
	[local30 15] = [-1 82 90 112 118 130 82 90 97 112 130 94 98 111 125]
	[local45 15] = [-1 10 13 22 32 41 10 13 20 29 41 17 20 22 30]
	local60
	local61 = -1
	local62 = -1
	local63
)

(instance rm610 of LBRoom
	(properties
		name {rm610}
		noun 29
		picture 610
		north 630
		east 640
		south 600
		vanishingX 165
		vanishingY 88
	)

	(method (init)
		(gEgo init: normalize: 831 setScale: Scaler 123 0 190 88)
		(self setRegions: 90)
		(switch gPrevRoomNum
			(north
				(gEgo edgeHit: 0 setHeading: 180)
				(northDoor caller: self)
			)
			(east
				(gEgo edgeHit: 0 setHeading: 270)
				(eastDoor caller: self)
			)
			(south
				(gCurRoom setScript: sEnterSouth self)
			)
			(620
				(self setScript: sClimbDownVat)
				(if (gEgo has: 11)
					(gTheIconBar enable: 7)
				)
			)
			(666
				(Palette palSET_INTENSITY 0 255 100)
				(gEgo posn: 84 132)
				(self setScript: sEnterFromTunnel)
			)
			(26 ; actBreak
				(self setScript: sClimbDownVat)
			)
			(else
				(gEgo wearingGown: 1 posn: 160 160)
				(gGame handsOn:)
			)
		)
		(gGameMusic2 number: 610 loop: -1 flags: 1 play:)
		(super init:)
		(LoadMany rsVIEW 611 612)
		(northDoor init:)
		(if
			(or
				(and (== gAct 3) (TimeCheck $1008)) ; has 1:00 am occurred?
				(>= gAct 4)
				(not (IsFlag 50))
			)
			(northDoor locked: 0)
		else
			(northDoor locked: 1)
		)
		(eastDoor init:)
		(if (and (IsFlag 18) (not (IsFlag 4)))
			(eastDoor locked: 1)
		)
		(oilJar
			setCel:
				(cond
					((IsFlag 105) 3)
					((IsFlag 106) 2)
					((IsFlag 107) 1)
					(else 0)
				)
			approachVerbs: 1 4 8 25
			init:
			nsTop: 140
			nsLeft: 4
			nsBottom: 189
			nsRight: 72
		)
		(sink approachVerbs: 25 8 init:)
		(desk approachVerbs: 25 8 init:)
		(drain approachVerbs: 25 8 init:)
		(light init:)
		(funnel init:)
		(longPipe init:)
		(shortPipe init:)
		(southExit init:)
		(if (and (IsFlag 20) (not (== gPrevRoomNum 620)) (not (== gPrevRoomNum 26))) ; actBreak
			(sHeimlichMusic play:)
			(MuseumRgn loadPolyList:)
			((ScriptID 32 0) ; aHeimlich
				init:
				view: 814
				room: 610
				posn: 228 153
				setScale: 156
				loop: 1
			)
			(= local60 1)
		else
			; Sierra indexes both approach arrays by vat number; the decompiled
			; chain used the next vat's init: result as the approachY index, so
			; Hand on a vat sent Laura toward a garbage point and out the south
			; exit (PLAY-033).
			(Load rsSOUND 40)
			(vat1 approachVerbs: 4 approachX: local1 approachY: [local15 1] init:)
			(vat2 approachVerbs: 4 approachX: local2 approachY: [local15 2] init:)
			(vat3 approachVerbs: 4 approachX: local3 approachY: [local15 3] init:)
			(vat4 approachVerbs: 4 approachX: local4 approachY: [local15 4] init:)
			(vat5 approachVerbs: 4 approachX: local5 approachY: [local15 5] init:)
			(vat6 approachVerbs: 4 approachX: local6 approachY: [local15 6] init:)
			(vat7 approachVerbs: 4 approachX: local7 approachY: [local15 7] init:)
			(vat8 approachVerbs: 4 approachX: local8 approachY: [local15 8] init:)
			(vat9 approachVerbs: 4 approachX: local9 approachY: [local15 9] init:)
			(vat10 approachX: local10 approachY: [local15 10] approachVerbs: 4 init:)
			(vat11 approachVerbs: 4 approachX: local11 approachY: [local15 11] init:)
			(vat12 approachVerbs: 4 approachX: local12 approachY: [local15 12] init:)
			(vat13 approachVerbs: 4 approachX: local13 approachY: [local15 13] init:)
			(vat14 approachVerbs: 4 approachX: local14 approachY: [local15 14] init:)
		)
	)

	(method (doit)
		(if
			(and
				(== (gEgo edgeHit:) 3)
				(& ((gTheIconBar at: 7) signal:) $0004)
			)
			(gTheIconBar enable: 7)
		)
		(if (and (not (gCurRoom script:)) (StepOn gEgo 64))
			(gCurRoom setScript: sExitSouth)
		)
		(super doit:)
	)

	(method (dispose)
		(if (and (not (== gNewRoomNum 620)) (IsFlag 20))
			(ClearFlag 21)
			((ScriptID 90 13) setReal: (ScriptID 90 13) 30) ; fumeTimer, fumeTimer
		)
		(if (!= gNewRoomNum 620)
			(gGameMusic2 fade:)
		)
		(kickTimer dispose: delete:)
		(sHeimlichMusic fade:)
		(super dispose:)
	)

	(method (cue)
		(cond
			(local60
				(gCurRoom setScript: sKickOut)
			)
			(
				(and
					(not (IsFlag 154))
					(not (IsFlag 4))
					(not
						(and
							(== gAct 3)
							(TimeCheck $b102) ; has 11:15 pm occurred?
							(not (TimeCheck $1310)) ; has 1:45 am occurred?
						)
					)
				)
				(eastDoor setScript: sWaterPrompt)
			)
		)
		(if (and (== gAct 4) (TimeCheck $3002 1) (not (TimeCheck $3002))) ; can 3:00 am occur?, has 3:00 am occurred?
			((ScriptID 90 15) seconds: 2) ; meetingTimer
			(= global111 15)
		)
	)
)

(instance sExitSouth of Script
	(properties
		name {sExitSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gTheIconBar enable: 7)
				(gGame handsOff:)
				(gEgo setHeading: 180 setMotion: MoveFwd 80 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties
		name {sEnterSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo x: 120 y: 270)
				(= cycles 1)
			)
			(1
				(gEgo setHeading: 0 setMotion: MoveFwd 100 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWaterPrompt of Script
	(properties
		name {sWaterPrompt}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= seconds 3)
			)
			(1
				(gMessager say: 32 0 0 0 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromTunnel of Script
	(properties
		name {sEnterFromTunnel}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 58 144 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbUpVat of Script
	(properties
		name {sClimbUpVat}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(= local61 -1)
				(= local62 -1)
				; Sierra picks the side before choosing the loop; the decompiled
				; source folded this into scaleY's index (PLAY-033).
				(if (> (gEgo x:) 180)
					(= register 1)
				else
					(= register 0)
				)
				(gEgo
					view: 612
					setLoop: register
					setCel: 0
					code: footstepCode
					scaleX: [local30 global129]
					scaleY: [local30 global129]
					setScale:
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: (+ register 2)
					setCel: 0
					setCycle: Fwd
					setMotion:
						MoveTo
						(gEgo x:)
						(- (gEgo y:) [local45 global129])
						self
				)
			)
			(2
				(gEgo setMotion: 0 code: 0)
				(gCurRoom newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance footstepCode of Code
	(properties
		name {footstepCode}
	)

	(method (doit)
		(cond
			((> (gEgo loop:) 1)
				(if
					(and
						(or (== (gEgo cel:) 1) (== (gEgo cel:) 4))
						(!= local62 (gEgo cel:))
					)
					(sFX play:)
					(= local62 (gEgo cel:))
				)
			)
			(
				(and
					(or
						(== (gEgo cel:) 4)
						(== (gEgo cel:) 7)
						(== (gEgo cel:) 11)
					)
					(!= local61 (gEgo cel:))
				)
				(sFX play:)
				(= local61 (gEgo cel:))
			)
		)
	)
)

(instance sClimbDownVat of Script
	(properties
		name {sClimbDownVat}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				; Sierra's order: handsOff, pick the side, then index every array
				; by vat number; the decompiled source used the side and
				; handsOff's result as indexes (PLAY-033).
				(gGame handsOff:)
				(if (> [local0 global129] 180)
					(= register 1)
				else
					(= register 0)
				)
				(gEgo
					view: 612
					setLoop: (+ register 2)
					setCel: (gEgo lastCel:)
					posn:
						[local0 global129]
						(- [local15 global129] [local45 global129])
					code: footstepCode
					scaleX: [local30 global129]
					scaleY: [local30 global129]
					setScale:
					setCycle: Rev
					setMotion: MoveTo [local0 global129] [local15 global129] self
				)
			)
			(1
				(gEgo setLoop: register setCel: 13 setCycle: Beg self)
			)
			(2
				(gEgo
					normalize: 831
					code: 0
					loop: (if register 0 else 1)
					setScale: Scaler 123 0 190 88
				)
				(= cycles 1)
			)
			(3
				(if (IsFlag 21)
					(gMessager say: 27 0 2)
				else
					(gMessager say: 27 0 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKickOut of Script
	(properties
		name {sKickOut}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gMessager say: 28 0 5)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(kickTimer setReal: kickTimer 7)
				(self dispose:)
			)
		)
	)
)

(instance sKickOut2 of Script
	(properties
		name {sKickOut2}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gTheIconBar enable: 7)
				(gGame handsOff:)
				(gMessager say: 28 0 6)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 108 252 self)
			)
			(2
				(gCurRoom newRoom: (gCurRoom south:))
				(self dispose:)
			)
		)
	)
)

(instance sDumpIt of Script
	(properties
		name {sDumpIt}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				(gEgo view: 611 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(= ticks 20)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 831 loop: 0)
				(= cycles 1)
			)
			(4
				(gMessager say: 3 25 14 0 self)
			)
			(5
				(gGame handsOn:)
				(= global150 0)
				((gInventory at: 14) cel: 1)
				(= local63 1)
				(self dispose:)
			)
		)
	)
)

(instance northDoor of Door
	(properties
		name {northDoor}
		x 187
		y 120
		noun 1
		approachX 189
		approachY 125
		view 611
		priority 8
		signal 16
		entranceTo 630
		moveToX 184
		moveToY 118
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 173 122 173 117 189 117 189 122 172 122)
	)
)

(instance eastDoor of Door
	(properties
		name {eastDoor}
		x 306
		y 149
		noun 2
		approachX 311
		approachY 155
		view 611
		loop 1
		priority 10
		signal 16
		entranceTo 640
		listenVerb 38
		moveToX 315
		moveToY 147
		enterType 0
		exitType 0
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 38)
	)

	(method (listen)
		(if
			(or
				(IsFlag 154)
				(IsFlag 4)
				(and (== gAct 3) (TimeCheck $b102) (not (TimeCheck $1310))) ; has 11:15 pm occurred?, has 1:45 am occurred?
			)
			(super listen:)
		else
			(gMessager say: 2 38 4)
			(gGame points: 1 154)
		)
	)

	(method (createPoly)
		(super createPoly: 311 150 318 152 318 156 310 153)
	)
)

(instance kickTimer of Timer
	(properties
		name {kickTimer}
	)

	(method (cue)
		(if (not (gCurRoom script:))
			(gCurRoom setScript: sKickOut2)
		)
	)
)

(instance oilJar of View
	(properties
		name {oilJar}
		x 25
		y 165
		z 11
		noun 31
		approachX 68
		approachY 181
		view 611
		loop 2
		priority 15
		signal 16400
	)

	(method (doVerb param1)
		(switch param1
			(1
				(cond
					((IsFlag 105)
						(gMessager say: 31 1 10)
					)
					((IsFlag 106)
						(gMessager say: 31 1 9)
					)
					((IsFlag 107)
						(gMessager say: 31 1 8)
					)
					(else
						(gMessager say: 31 1 7)
					)
				)
			)
			(8
				(if (gEgo has: 14)
					(if (IsFlag 105)
						(gMessager say: 31 8 10)
					else
						(gMessager say: 31 8 11)
					)
				else
					(gMessager say: 31 8 12)
				)
			)
			(4
				(if (IsFlag 105)
					(gMessager say: 31 4 10)
				else
					(gMessager say: 31 4 17)
				)
			)
			(25
				(cond
					((== global150 4)
						(gMessager say: 33 1 9 0 0 15)
					)
					((IsFlag 105)
						(gMessager say: 31 1 10)
					)
					(else
						(= global150 4)
						((gInventory at: 14) cel: 0)
						(cond
							((IsFlag 106)
								(ClearFlag 106)
								(SetFlag 105)
								(self setCel: 3)
							)
							((IsFlag 107)
								(ClearFlag 107)
								(SetFlag 106)
								(self setCel: 2)
							)
							(else
								(SetFlag 107)
								(self setCel: 1)
							)
						)
						(gMessager say: 33 1 9 0 0 15)
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance sink of Feature
	(properties
		name {sink}
		x 180
		y 167
		noun 3
		nsTop 157
		nsLeft 162
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 2
		approachX 161
		approachY 184
	)

	(method (doVerb param1)
		(switch param1
			(1
				(if local63
					(gMessager say: 3 1 13)
				else
					(gMessager say: 3 1)
				)
			)
			(8
				(if local63
					(gMessager say: 3 8 13)
				else
					(gMessager say: 3 8)
				)
			)
			(25
				(if global150
					(gCurRoom setScript: sDumpIt)
				else
					(gMessager say: 3 25 15)
				)
			)
			(4
				(if local63
					(gMessager say: 3 4 13)
				else
					(gMessager say: 3 4)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat1 of Feature
	(properties
		name {vat1}
		x 206
		y 102
		noun 4
		nsTop 75
		nsLeft 204
		nsBottom 130
		nsRight 208
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 1)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat2 of Feature
	(properties
		name {vat2}
		x 213
		y 101
		noun 5
		nsTop 71
		nsLeft 210
		nsBottom 132
		nsRight 216
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 2)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat3 of Feature
	(properties
		name {vat3}
		x 221
		y 102
		noun 6
		nsTop 66
		nsLeft 217
		nsBottom 138
		nsRight 225
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 3)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat4 of Feature
	(properties
		name {vat4}
		x 230
		y 100
		noun 7
		nsTop 56
		nsLeft 225
		nsBottom 145
		nsRight 236
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 4)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat5 of Feature
	(properties
		name {vat5}
		x 266
		y 100
		noun 8
		nsTop 44
		nsLeft 237
		nsBottom 156
		nsRight 295
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 5)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat6 of Feature
	(properties
		name {vat6}
		x 161
		y 102
		noun 9
		nsTop 78
		nsLeft 159
		nsBottom 126
		nsRight 163
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 6)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat7 of Feature
	(properties
		name {vat7}
		x 155
		y 102
		noun 10
		nsTop 74
		nsLeft 152
		nsBottom 130
		nsRight 159
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 7)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat8 of Feature
	(properties
		name {vat8}
		x 146
		y 100
		noun 11
		nsTop 66
		nsLeft 141
		nsBottom 135
		nsRight 152
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 8)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat9 of Feature
	(properties
		name {vat9}
		x 134
		y 99
		noun 12
		nsTop 57
		nsLeft 128
		nsBottom 142
		nsRight 140
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 9)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat10 of Feature
	(properties
		name {vat10}
		x 98
		y 99
		noun 13
		nsTop 44
		nsLeft 72
		nsBottom 154
		nsRight 125
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 10)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat11 of Feature
	(properties
		name {vat11}
		x 65
		y 100
		noun 14
		nsTop 67
		nsLeft 59
		nsBottom 133
		nsRight 71
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 11)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat12 of Feature
	(properties
		name {vat12}
		x 50
		y 100
		noun 15
		nsTop 64
		nsLeft 42
		nsBottom 136
		nsRight 58
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 12)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat13 of Feature
	(properties
		name {vat13}
		x 31
		y 100
		noun 16
		nsTop 59
		nsLeft 20
		nsBottom 141
		nsRight 42
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 13)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance vat14 of Feature
	(properties
		name {vat14}
		x 9
		y 92
		noun 17
		nsTop 51
		nsBottom 133
		nsRight 19
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(= global129 14)
				(gCurRoom setScript: sClimbUpVat)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance desk of Feature
	(properties
		name {desk}
		x 27
		y 161
		noun 18
		nsTop 134
		nsBottom 189
		nsRight 54
		sightAngle 40
		onMeCheck 4
		approachX 78
		approachY 183
	)

	(method (doVerb param1)
		(switch param1
			(25
				(if global150
					(gMessager say: 18 25 14)
					(-- global150)
					((gInventory at: 14) cel: (if global150 0 else 1))
				else
					(gMessager say: 18 25 15)
				)
			)
			(6
				(gMessager say: 18 6 3)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance drain of Feature
	(properties
		name {drain}
		x 110
		y 172
		noun 19
		nsTop 169
		nsLeft 98
		nsBottom 176
		nsRight 122
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(25
				(if global150
					(gMessager say: 19 25 14)
					(-- global150)
					((gInventory at: 14) cel: (if global150 0 else 1))
				else
					(gMessager say: 19 25 15)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance light of Feature
	(properties
		name {light}
		x 38
		y 195
		z 100
		noun 20
		nsTop 90
		nsLeft 29
		nsBottom 100
		nsRight 48
		sightAngle 40
		onMeCheck 8
	)
)

(instance funnel of Feature
	(properties
		name {funnel}
		x 208
		y 150
		noun 21
		nsTop 145
		nsLeft 201
		nsBottom 155
		nsRight 216
		sightAngle 40
	)
)

(instance longPipe of Feature
	(properties
		name {longPipe}
		x 159
		y 31
		noun 22
		nsTop 29
		nsBottom 33
		nsRight 319
		sightAngle 40
	)
)

(instance shortPipe of Feature
	(properties
		name {shortPipe}
		x 263
		y 17
		noun 23
		nsTop 15
		nsLeft 208
		nsBottom 20
		nsRight 319
		sightAngle 40
	)
)

(instance southExit of ExitFeature
	(properties
		name {southExit}
		nsTop 185
		nsLeft 52
		nsBottom 189
		nsRight 159
		cursor 11
		exitDir 3
		noun 30
	)
)

(instance sFX of Sound
	(properties
		name {sFX}
		flags 1
		number 613
	)
)

(instance sHeimlichMusic of Sound
	(properties
		name {sHeimlichMusic}
		flags 1
		number 19
		loop -1
	)
)
