;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use n027)
(use Game)
(use Actor)
(use System)

(public
	RotundaRgn 0
	Countess 1
	proc93_2 2
	Heimlich 3
	Olympia 4
	O_Riley 5
	Pippin 6
	Rameses 7
	Steve 8
	Tut 9
	Watney 10
	Yvette 11
	Ziggy 12
)

(procedure (proc93_2)) ; UNUSED

(class RotundaRgn of Rgn
	(properties
		name {RotundaRgn}
		convRoom 0
		convReturn 0
	)

	(method (init)
		(super init:)
		(= convRoom
			(switch global128
				(0 350)
				(1 350)
				(2 360)
				(3 360)
				(4 350)
				(5 350)
				(6 370)
				(7 370)
				(8 370)
				(9 350)
				(10 360)
				(11 360)
				(12 360)
				(13 350)
			)
		)
		(Countess approachDist: 20 approachVerbs: 2 6)
		(Heimlich approachDist: 20 approachVerbs: 2 6)
		(Olympia approachDist: 20 approachVerbs: 2 6)
		(O_Riley approachDist: 20 approachVerbs: 2 6)
		(Pippin approachDist: 20 approachVerbs: 2 6)
		(Rameses approachDist: 20 approachVerbs: 2 6)
		(Steve approachDist: 20 approachVerbs: 2 6)
		(Tut approachDist: 20 approachVerbs: 2 6)
		(Watney approachDist: 20 approachVerbs: 2 6)
		(Yvette approachDist: 20 approachVerbs: 2 6)
		(Ziggy approachDist: 20 approachVerbs: 2 6)
	)

	(method (newRoom param1)
		(= keep (OneOf param1 335 340 350 355 360 370 400))
		(= initialized 0)
		(cond
			((not (== gAct 2)))
			((OneOf param1 335 400 420)
				(gGameMusic1 fade: 50 5 5 0)
			)
			((== param1 340)
				(gGameMusic1 fade: 100 5 5 0)
			)
		)
		(if (and (& $7204 gMustDos) (not (IsFlag 71)) (== param1 360))
			(SetFlag 71)
		)
		(super newRoom: param1)
	)

	(method (notify)
		(= convReturn gCurRoomNum)
		(gCurRoom newRoom: 340)
	)
)

(instance Countess of Actor
	(properties
		name {Countess}
		noun 1
		modNum 1884
		view 813
		signal 16384
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 269) ; addCluesCode
		)
		(cond
			((== param1 2)
				(if (not (SetFlag 112))
					(gMessager say: noun param1 80 0 0 modNum)
				else
					(super doVerb: param1)
				)
			)
			((OneOf param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
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
				(cond
					((not (Message msgGET modNum noun 6 temp1 1))
						(gMessager say: noun 6 81 0 0 modNum)
					)
					((proc27_0 0 [global296 (- temp1 2)])
						(gMessager say: noun 6 1 0 0 modNum)
					)
					(else
						(gMessager say: noun 6 temp1 0 0 modNum)
						(proc27_1 0 @[global296 (- temp1 2)])
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance Heimlich of Actor
	(properties
		name {Heimlich}
		noun 1
		modNum 1889
		view 814
		signal 16384
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 265) ; addCluesCode
		)
		(if (OneOf param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
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
			(cond
				((not (Message msgGET modNum noun 6 temp1 1))
					(gMessager say: noun 6 81 0 0 modNum)
				)
				((proc27_0 2 [global296 (- temp1 2)])
					(gMessager say: noun 6 1 0 0 modNum)
				)
				(else
					(gMessager say: noun 6 temp1 0 0 modNum)
					(proc27_1 2 @[global296 (- temp1 2)])
				)
			)
		else
			(super doVerb: param1)
		)
	)
)

(instance Olympia of Actor
	(properties
		name {Olympia}
		noun 1
		modNum 1892
		view 820
		signal 16384
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 270) ; addCluesCode
		)
		(if (OneOf param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
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
			(cond
				((not (Message msgGET modNum noun 6 temp1 1))
					(gMessager say: noun 6 81 0 0 modNum)
				)
				((proc27_0 3 [global296 (- temp1 2)])
					(gMessager say: noun 6 1 0 0 modNum)
				)
				(else
					(gMessager say: noun 6 temp1 0 0 modNum)
					(proc27_1 3 @[global296 (- temp1 2)])
				)
			)
		else
			(super doVerb: param1)
		)
	)
)

(instance O_Riley of Actor
	(properties
		name {O'Riley}
		noun 1
		modNum 1888
		view 819
		signal 16384
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 260) ; addCluesCode
		)
		(if (== param1 22)
			(super doVerb: param1)
			(if (gEgo has: 11)
				(gEgo put: 11)
			)
			(return)
		)
		(cond
			((== param1 2)
				(if (not (SetFlag 114))
					(gMessager say: noun param1 80 0 0 modNum)
				else
					(super doVerb: param1)
				)
			)
			((OneOf param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
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
					(258
						(cond
							((IsFlag 134)
								(if (proc27_0 4 global364)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 72 0 0 modNum)
									(proc27_1 4 @global364)
								)
							)
							((proc27_0 4 global297)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 3 0 0 modNum)
								(proc27_1 4 @global297)
							)
						)
					)
					(259
						(cond
							((or (IsFlag 171) (IsFlag 12))
								(if (proc27_0 4 global363)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 69 0 0 modNum)
									(proc27_1 4 @global363)
								)
							)
							((proc27_0 4 global298)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 4 0 0 modNum)
								(proc27_1 4 @global298)
							)
						)
					)
					(264
						(cond
							((or (IsFlag 143) (IsFlag 72))
								(if (proc27_0 4 global366)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 74 0 0 modNum)
									(proc27_1 4 @global366)
								)
							)
							((proc27_0 4 global303)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 9 0 0 modNum)
								(proc27_1 4 @global303)
							)
						)
					)
					(266
						(cond
							((or (IsFlag 161) (IsFlag 68))
								(if (proc27_0 4 global367)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 73 0 0 modNum)
									(proc27_1 4 @global367)
								)
							)
							((proc27_0 4 global305)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 11 0 0 modNum)
								(proc27_1 4 @global305)
							)
						)
					)
					(267
						(cond
							((or (IsFlag 158) (IsFlag 67))
								(if (proc27_0 4 global365)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 71 0 0 modNum)
									(proc27_1 4 @global365)
								)
							)
							((proc27_0 4 global306)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 12 0 0 modNum)
								(proc27_1 4 @global306)
							)
						)
					)
					(780
						(cond
							(
								(or
									(IsFlag 155)
									(IsFlag 22)
									(gEgo has: 11)
								)
								(if (proc27_0 4 global368)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 75 0 0 modNum)
									(proc27_1 4 @global368)
								)
							)
							((proc27_0 4 global332)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 38 0 0 modNum)
								(proc27_1 4 @global332)
							)
						)
					)
					(else
						(cond
							((not (Message msgGET modNum noun 6 temp1 1))
								(gMessager say: noun 6 81 0 0 modNum)
							)
							((proc27_0 4 [global296 (- temp1 2)])
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 temp1 0 0 modNum)
								(proc27_1 4 @[global296 (- temp1 2)])
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
)

(instance Pippin of Actor
	(properties
		name {Pippin}
		noun 1
		modNum 1882
		view 822
		signal 16384
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 258) ; addCluesCode
		)
		(cond
			((== param1 2)
				(if (not (SetFlag 110))
					(gMessager say: noun param1 80 0 0 modNum)
				else
					(super doVerb: param1)
				)
			)
			((OneOf param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
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
				(cond
					((not (Message msgGET modNum noun 6 temp1 1))
						(gMessager say: noun 6 81 0 0 modNum)
					)
					((proc27_0 5 [global296 (- temp1 2)])
						(gMessager say: noun 6 1 0 0 modNum)
					)
					(else
						(gMessager say: noun 6 temp1 0 0 modNum)
						(proc27_1 5 @[global296 (- temp1 2)])
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance Rameses of Actor
	(properties
		name {Rameses}
		noun 1
		modNum 1891
		view 823
		signal 16384
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 268) ; addCluesCode
		)
		(cond
			((== param1 2)
				(if (not (SetFlag 115))
					(gMessager say: noun param1 80 0 0 modNum)
				else
					(super doVerb: param1)
				)
			)
			((OneOf param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
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
				(cond
					((not (Message msgGET modNum noun 6 temp1 1))
						(gMessager say: noun 6 81 0 0 modNum)
					)
					((proc27_0 6 [global296 (- temp1 2)])
						(gMessager say: noun 6 1 0 0 modNum)
					)
					(else
						(gMessager say: noun 6 temp1 0 0 modNum)
						(proc27_1 6 @[global296 (- temp1 2)])
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance Steve of Actor
	(properties
		name {Steve}
		noun 1
		modNum 1887
		view 812
		signal 16384
		scaleSignal 1
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 263) ; addCluesCode
		)
		(if (== param1 6)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
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
			(cond
				((not (Message msgGET modNum noun 6 temp1 1))
					(gMessager say: noun 6 81 0 0 modNum)
				)
				((proc27_0 10 [global296 (- temp1 2)])
					(gMessager say: noun 6 1 0 0 modNum)
				)
				(else
					(gMessager say: noun 6 temp1 0 0 modNum)
					(proc27_1 10 @[global296 (- temp1 2)])
				)
			)
		else
			(super doVerb: param1)
		)
	)
)

(instance Tut of Actor
	(properties
		name {Tut}
		noun 1
		modNum 1883
		view 821
		signal 16384
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 271) ; addCluesCode
		)
		(cond
			((== param1 2)
				(if (not (SetFlag 111))
					(gMessager say: noun param1 80 0 0 modNum)
				else
					(super doVerb: param1)
				)
			)
			((OneOf param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
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
				(cond
					((not (Message msgGET modNum noun 6 temp1 1))
						(gMessager say: noun 6 81 0 0 modNum)
					)
					((proc27_0 7 [global296 (- temp1 2)])
						(gMessager say: noun 6 1 0 0 modNum)
					)
					(else
						(gMessager say: noun 6 temp1 0 0 modNum)
						(proc27_1 7 @[global296 (- temp1 2)])
					)
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)

(instance Watney of Actor
	(properties
		name {Watney}
		noun 1
		modNum 1886
		view 815
		signal 16384
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (== param1 6)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
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
			(cond
				((not (Message msgGET modNum noun 6 temp1 1))
					(gMessager say: noun 6 81 0 0 modNum)
				)
				((proc27_0 8 [global296 (- temp1 2)])
					(gMessager say: noun 6 1 0 0 modNum)
				)
				(else
					(gMessager say: noun 6 temp1 0 0 modNum)
					(proc27_1 8 @[global296 (- temp1 2)])
				)
			)
		else
			(super doVerb: param1)
		)
	)
)

(instance Yvette of Actor
	(properties
		name {Yvette}
		noun 1
		modNum 1885
		view 817
		signal 16384
		scaleSignal 1
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 266) ; addCluesCode
		)
		(cond
			((== param1 2)
				(if (not (SetFlag 113))
					(gMessager say: noun param1 80 0 0 modNum)
				else
					(gMessager say: noun param1 28 0 0 modNum)
				)
			)
			((OneOf param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
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
					(267
						(cond
							((IsFlag 158)
								(if (proc27_0 9 global365)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 71 0 0 modNum)
									(proc27_1 9 @global365)
								)
							)
							((proc27_0 9 global306)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 12 0 0 modNum)
								(proc27_1 9 @global306)
							)
						)
					)
					(263
						(if (proc27_0 9 global302)
							(gMessager say: noun 6 1 0 0 modNum)
						else
							(gMessager say: noun 6 8 0 0 modNum)
							(proc27_1 9 @global302)
						)
					)
					(else
						(cond
							((not (Message msgGET modNum noun 6 temp1 1))
								(gMessager say: noun 6 81 0 0 modNum)
							)
							((proc27_0 9 [global296 (- temp1 2)])
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 temp1 0 0 modNum)
								(proc27_1 9 @[global296 (- temp1 2)])
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
)

(instance Ziggy of Actor
	(properties
		name {Ziggy}
		noun 1
		modNum 1890
		view 816
		signal 16384
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(if (OneOf param1 1 2)
			((ScriptID 21 0) doit: 264) ; addCluesCode
		)
		(if (OneOf param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
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
			(cond
				((not (Message msgGET modNum noun 6 temp1 1))
					(gMessager say: noun 6 81 0 0 modNum)
				)
				((proc27_0 11 [global296 (- temp1 2)])
					(gMessager say: noun 6 1 0 0 modNum)
				)
				(else
					(gMessager say: noun 6 temp1 0 0 modNum)
					(proc27_1 11 @[global296 (- temp1 2)])
				)
			)
		else
			(super doVerb: param1)
		)
	)
)
