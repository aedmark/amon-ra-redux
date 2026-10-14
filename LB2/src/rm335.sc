;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use Scaler)
(use PolyPath)
(use Feature)
(use Actor)
(use StopWalk)
(use Motion)
(use System)

(public
	rm335 0
)

(instance rm335 of LBRoom
	(properties
		name {rm335}
		noun 5
		picture 335
		north 350
		south 330
	)

	(method (init)
		(gEgo
			init:
			normalize: (if (gEgo wearingGown:) 831 else 830)
			setScale: Scaler 100 75 190 160
		)
		(self setRegions: 90 93)
		(switch gPrevRoomNum
			(north
				(Palette palSET_INTENSITY 0 255 60)
				(if (and (TimeCheck $0008) (IsFlag 122) (not (IsFlag 133)))
					(frontDoor cel: 255 state: 2 enterType: 2 forceClose: 0)
					(self setScript: sOffToSmooch)
				else
					(frontDoor forceOpen: 1)
					(gEgo
						posn: (frontDoor moveToX:) (frontDoor moveToY:)
						edgeHit: 0
					)
				)
			)
			(south
				(self setScript: sEnterSouth)
				(cond
					((!= gAct 2))
					((IsFlag 25)
						(gGameMusic1 number: 335 flags: 1 setLoop: -1 play: 50)
					)
					(else
						(gGameMusic1 number: 19 flags: 1 setLoop: -1 play:)
					)
				)
			)
			(else
				(gEgo posn: 150 180)
				(gGame handsOn:)
			)
		)
		(super init:)
		(southExitFeature init:)
		(frontDoor init: setPri: 12)
		(otherDoor init:)
		(banner init: approachVerbs: 4 8)
		(glass init:)
		(column init:)
		(if (and (== gAct 2) (not (IsFlag 25)))
			(benefitPodium
				init:
				setPri: 12
				approachX: 186
				approachY: 180
				approachDist: 4
				sightAngle: -1
				approachVerbs: 1 4 8
			)
			((ScriptID 32 0) ; aHeimlich
				init:
				view: 341
				room: gCurRoomNum
				posn: 131 173 0
				setLoop: 0
				actions: doorActions
				approachX: 137
				approachY: 180
				approachVerbs: 4 11 2 6
			)
		else
			(frontDoor locked: (!= gAct 2))
		)
	)

	(method (newRoom)
		(gGameMusic1 fade:)
		(super newRoom: &rest)
	)

	(method (doit)
		(if (and (== gAct 2) (not (IsFlag 25)))
			; RestoreGame can replace these with values from an old save.
			(benefitPodium approachX: 186 approachY: 180 approachDist: 4 sightAngle: -1)
			((ScriptID 2335 0) doit: (gCurRoom obstacles:) 1) ; poly2335Code
		)
		(super doit:)
	)
)

(instance sEnterSouth of Script
	(properties
		name {sEnterSouth}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gEgo posn: 165 240 setMotion: PolyPath 165 185 self)
			)
			(1
				(gGame handsOn:)
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
				(frontDoor caller: self open:)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(frontDoor moveToX:)
						(frontDoor moveToY:)
						self
				)
			)
			(2
				(DrawPic 780 10)
				(gCast eachElementDo: 102)
				(= cycles 2)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sGiveInvite of Script
	(properties
		name {sGiveInvite}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gGame handsOff:)
				((ScriptID 32 0) setLoop: 0 cycleSpeed: 6 setCycle: CT 8 1 self) ; aHeimlich
			)
			(1
				(= ticks 15)
			)
			(2
				((ScriptID 32 0) setCycle: End self) ; aHeimlich
			)
			(3
				((ScriptID 32 0) setCel: 0) ; aHeimlich
				(= cycles 2)
			)
			(4
				(gMessager say: 6 11 0 0 self)
			)
			(5
				(SetFlag 23)
				(gEgo put: 6)
				((ScriptID 21 1) doit: 775) ; dropCluesCode
				((ScriptID 22 0) doit: 28673) ; triggerAndClock
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHeimlichStare of Script
	(properties
		name {sHeimlichStare}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				; Narrator describes him, then Heimlich answers from his own message module.
				(gMessager say: 6 8 0 0 self)
			)
			(1
				(gMessager say: 1 8 0 0 self 1889)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sOffToSmooch of Script
	(properties
		name {sOffToSmooch}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(gEgo posn: 153 160 setMotion: PolyPath 160 250 self)
				(= cycles 1)
			)
			(1
				(DrawPic 335)
				(Palette palSET_INTENSITY 0 255 60)
				(= ticks 15)
			)
			(2
				((ScriptID 93 8) ; Steve
					init:
					setCycle: StopWalk -1
					posn: 153 160
					setMotion: PolyPath 130 260
				)
			)
			(3
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance frontDoor of Door
	(properties
		name {frontDoor}
		x 164
		y 162
		noun 3
		approachX 152
		approachY 173
		view 336
		moveToX 152
		moveToY 152
		enterType 0
		exitType 0
	)

	(method (doVerb param1)
		(switch param1
			(4
				(cond
					((not (gEgo wearingGown:))
						(gMessager say: noun 4 6)
					)
					((not (IsFlag 23))
						(gMessager say: noun 4 7)
					)
					(else
						(gCurRoom setScript: sExitNorth)
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		name {southExitFeature}
		nsTop 184
		nsLeft 80
		nsBottom 189
		nsRight 290
		cursor 11
		exitDir 3
		noun 4
	)
)

(instance banner of Feature
	(properties
		name {banner}
		x 215
		y 123
		noun 1
		nsTop 80
		nsLeft 203
		nsBottom 137
		nsRight 258
		sightAngle 40
	)
)

(instance glass of Feature
	(properties
		name {glass}
		x 140
		y 70
		noun 2
		sightAngle 40
		onMeCheck 8192
	)
)

(instance otherDoor of Feature
	(properties
		name {otherDoor}
		x 131
		y 141
		noun 16
		nsTop 115
		nsLeft 121
		nsBottom 167
		nsRight 142
		sightAngle 40
	)

	(method (doVerb param1)
		(if (== param1 4)
			(frontDoor doVerb: param1)
		else
			(super doVerb: param1)
		)
	)
)

(instance column of Feature
	(properties
		name {column}
		x 30
		y 170
		noun 8
		sightAngle 40
		onMeCheck 16384
	)
)

(instance benefitPodium of View
	(properties
		name {benefitPodium}
		x 190
		y 174
		view 335
		loop 0
		cel 0
		priority 12
		signal 16400
		noun 17
		nsTop 148
		nsLeft 182
		nsBottom 174
		nsRight 198
		sightAngle -1 ; sightAngle: never "already facing", so repeats use the deferred CueObj path
		approachX 186
		approachY 180
		approachDist 4 ; approachDist: already standing here skips a redundant re-approach
	)

	(method (doVerb param1)
		(if (OneOf param1 1 4 8)
			((ScriptID 21 0) doit: 263) ; Steve
			((ScriptID 21 0) doit: 265) ; Heimlich
			((ScriptID 21 0) doit: 266) ; Yvette
			((ScriptID 21 0) doit: 268) ; Rameses
			((ScriptID 21 0) doit: 269) ; Countess
			((ScriptID 21 0) doit: 270) ; Olympia
			((ScriptID 21 0) doit: 271) ; Tut
			(switch param1
				(4
					(if (not (IsFlag 124))
						(SetFlag 124)
						(gMessager say: noun 4 0)
					else
						(gMessager say: noun 4 1)
					)
				)
				(else
					(if (not (IsFlag 124))
						(gMessager say: noun 1 0)
					else
						(gMessager say: noun 1 1)
					)
				)
			)
		else
			; Consume the spurious follow-up dispatch produced after an approach.
			; LOOK, DO, and Magnifier are the podium's only supported verbs.
			(return 1)
		)
	)
)

(instance doorActions of Actions
	(properties
		name {doorActions}
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gMessager say: 6 1)
			)
			(4
				(gMessager say: 6 4)
			)
			(11
				(gCurRoom setScript: sGiveInvite)
			)
			(2
				(if (gEgo has: 6)
					(gMessager say: 6 2 7)
				else
					(gMessager say: 6 2)
				)
			)
			(6
				(gMessager say: 6 2)
			)
			(8
				(gCurRoom setScript: sHeimlichStare)
			)
			(else
				(return 0)
			)
		)
	)
)
