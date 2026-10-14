;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	rm235 0
)

(local
	local0 = 1
)

(instance rm235 of LBRoom
	(properties
		name {rm235}
		modNum 230
		noun 24
		picture 235
	)

	(method (init)
		(Load rsVIEW 235)
		(super init:)
		(closeupBlotterLF init:)
		(closeupBlotterLB init:)
		(closeupBlotterRF init:)
		(closeupBlotterRB init:)
		(pencilHolder init:)
		(drawer init:)
		(restOfBlotter init:)
		(if (IsFlag 29)
			(keyInDrawerC init:)
		)
		(proc0_8 1)
		(gGame handsOn:)
	)

	(method (dispose)
		(proc0_8 0)
		(super dispose:)
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gMessager say: 24 1 0 0 0 230)
			)
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance sLiftMat of Script
	(properties
		name {sLiftMat}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(switch register
					(0
						(if (gCast contains: cornerUpLF)
							(cornerUpLF dispose:)
						else
							(cornerUpLF init:)
						)
					)
					(1
						(if (gCast contains: cornerUpLB)
							(cornerUpLB dispose:)
						else
							(cornerUpLB init:)
						)
					)
					(2
						(if (gCast contains: cornerUpRF)
							(cornerUpRF dispose:)
							(keyUnder dispose:)
						else
							(if
								(and
									(not (gEgo has: 5))
									(not (IsFlag 29))
								)
								(keyUnder init:)
							)
							(cornerUpRF init:)
						)
					)
					(3
						(if (gCast contains: cornerUpRB)
							(cornerUpRB dispose:)
						else
							(cornerUpRB init:)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(cond
					((and (gCast contains: cornerUpRF) (== register 2))
						(if (and (not (gEgo has: 5)) (not (IsFlag 29)))
							(gMessager say: 10 4 1 0 self 230)
						else
							(gMessager say: 10 4 2 0 self 230)
						)
					)
					((and (gCast contains: cornerUpRB) (== register 3))
						(gMessager say: 10 4 2 0 self 230)
					)
					((and (gCast contains: cornerUpLB) (== register 1))
						(gMessager say: 10 4 2 0 self 230)
					)
					((and (gCast contains: cornerUpLF) (== register 0))
						(gMessager say: 10 4 2 0 self 230)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sUseKeyOnDrawer of Script
	(properties
		name {sUseKeyOnDrawer}
	)

	(method (changeState param1)
		(switch (= state param1)
			(0
				(= local0 0)
				(gEgo put: 5)
				((ScriptID 21 1) doit: 774) ; dropCluesCode
				(SetFlag 29)
				(gMessager say: 9 16 0 0 self 230)
			)
			(1
				(openDrawer init:)
				(sFX number: 42 play:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance openDrawer of View
	(properties
		name {openDrawer}
		x 66
		y 120
		noun 20
		modNum 230
		view 235
		loop 1
		signal 16385
	)

	(method (init)
		(super init:)
		(if (not (gEgo has: 6))
			(pressPass init:)
		)
		(if (IsFlag 29)
			(keyInDrawerC dispose:)
		)
		(keyInDrawerO init:)
	)

	(method (dispose)
		(super dispose:)
		(pressPass dispose:)
		(keyInDrawerO dispose:)
		(if (IsFlag 29)
			(keyInDrawerC init:)
		)
	)

	(method (doVerb param1)
		(switch param1
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(4
				(sFX number: 42 play:)
				(openDrawer dispose:)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance cornerUpLF of View
	(properties
		name {cornerUpLF}
		x 69
		y 100
		noun 19
		modNum 230
		view 235
		priority 8
		signal 16401
	)

	(method (doVerb param1)
		(switch param1
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance cornerUpRF of View
	(properties
		name {cornerUpRF}
		x 200
		y 100
		noun 19
		modNum 230
		view 235
		cel 1
		priority 8
		signal 16401
	)

	(method (doVerb param1)
		(switch param1
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance cornerUpRB of View
	(properties
		name {cornerUpRB}
		x 174
		y 83
		noun 19
		modNum 230
		view 235
		cel 2
		priority 8
		signal 16401
	)

	(method (doVerb param1)
		(switch param1
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance cornerUpLB of View
	(properties
		name {cornerUpLB}
		x 97
		y 85
		noun 19
		modNum 230
		view 235
		cel 3
		priority 8
		signal 16401
	)

	(method (doVerb param1)
		(switch param1
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance keyUnder of View
	(properties
		name {keyUnder}
		x 216
		y 118
		noun 21
		modNum 230
		view 235
		loop 3
		priority 9
		signal 16400
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gEgo get: 5)
				((ScriptID 21 0) doit: 774) ; addCluesCode
				(keyUnder dispose:)
			)
			(1
				(gCurRoom setInset: inKey)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance keyInDrawerO of View
	(properties
		name {keyInDrawerO}
		x 154
		y 155
		noun 22
		modNum 230
		view 235
		loop 2
		signal 16384
	)

	(method (doVerb param1)
		(switch param1
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance keyInDrawerC of View
	(properties
		name {keyInDrawerC}
		x 154
		y 132
		noun 23
		modNum 230
		view 235
		loop 2
		signal 16384
	)

	(method (doVerb param1)
		(switch param1
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance pressPass of View
	(properties
		name {pressPass}
		x 92
		y 137
		noun 27
		modNum 15
		view 235
		loop 4
		cel 1
		priority 14
		signal 16401
	)

	(method (doVerb param1)
		(switch param1
			(4
				((ScriptID 22 0) doit: 1) ; triggerAndClock
				(gGame points: 1 128)
				(gEgo get: 6)
				((ScriptID 21 0) doit: 775) ; addCluesCode
				(pressPass dispose:)
			)
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(1
				(gCurRoom setInset: inPressPass)
				(gMessager say: 27 1 0 0 0 15)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance inPressPass of Inset
	(properties
		name {inPressPass}
		view 235
		loop 4
		x 85
		y 129
		disposeNotOnMe 1
		modNum 15
		noun 27
	)

	(method (doVerb param1)
		(switch param1
			(4
				((ScriptID 22 0) doit: 1) ; triggerAndClock
				(gGame points: 1 128)
				(gEgo get: 6)
				((ScriptID 21 0) doit: 775) ; addCluesCode
				(pressPass dispose:)
				(inPressPass dispose:)
			)
			(1
				(gMessager say: 27 1 0 0 0 15)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance inKey of Inset
	(properties
		name {inKey}
		view 235
		loop 3
		cel 1
		x 187
		y 92
		hideTheCast 1
		disposeNotOnMe 1
		modNum 15
		noun 9
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb param1)
		(switch param1
			(1
				(gMessager say: 9 1 0 0 0 15)
			)
			(4
				(gEgo get: 5)
				((ScriptID 21 0) doit: 774) ; addCluesCode
				(inKey dispose:)
				(keyUnder dispose:)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance closeupBlotterRF of Feature
	(properties
		name {closeupBlotterRF}
		y 109
		noun 10
		modNum 230
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sLiftMat 0 2)
			)
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance closeupBlotterRB of Feature
	(properties
		name {closeupBlotterRB}
		y 95
		noun 10
		modNum 230
		sightAngle 40
		onMeCheck 8192
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sLiftMat 0 3)
			)
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance closeupBlotterLB of Feature
	(properties
		name {closeupBlotterLB}
		y 95
		noun 10
		modNum 230
		sightAngle 40
		onMeCheck 4096
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sLiftMat 0 1)
			)
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance closeupBlotterLF of Feature
	(properties
		name {closeupBlotterLF}
		y 109
		noun 10
		modNum 230
		sightAngle 40
		onMeCheck 2048
	)

	(method (doVerb param1)
		(switch param1
			(4
				(gCurRoom setScript: sLiftMat 0 0)
			)
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance restOfBlotter of Feature
	(properties
		name {restOfBlotter}
		y 109
		noun 26
		modNum 230
		onMeCheck 1024
	)

	(method (doVerb param1)
		(switch param1
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance pencilHolder of Feature
	(properties
		name {pencilHolder}
		x 227
		y 78
		noun 8
		modNum 230
		nsTop 64
		nsLeft 219
		nsBottom 92
		nsRight 236
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance drawer of Feature
	(properties
		name {drawer}
		x 155
		y 137
		noun 9
		modNum 230
		nsTop 128
		nsLeft 67
		nsBottom 146
		nsRight 244
		sightAngle 40
	)

	(method (doVerb param1)
		(switch param1
			(4
				(cond
					((gCast contains: openDrawer)
						(sFX number: 42 play:)
						(openDrawer dispose:)
					)
					((IsFlag 29)
						(sFX number: 42 play:)
						(openDrawer init:)
					)
					(local0
						(gMessager say: 9 4 3 0 0 230)
					)
					((not (gEgo has: 6))
						(sFX number: 42 play:)
						(openDrawer init:)
					)
					(else
						(gMessager say: 9 4 4 0 0 230)
					)
				)
			)
			(16
				(gCurRoom setScript: sUseKeyOnDrawer)
			)
			(13
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: param1 &rest)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		name {sFX}
		flags 5
		number 42
	)
)
