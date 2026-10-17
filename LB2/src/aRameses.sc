;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use n027)
(use MuseumRgn)

(public
	aRameses 0
)

(instance aRameses of MuseumActor
	(properties
		name {aRameses}
		noun 1
		modNum 1891
		originalView 823
		room 370
	)

	(method (doVerb param1 param2 &tmp temp0 temp1 temp2)
		(switch param1
			(2
				(if (not (SetFlag 115))
					(gMessager say: noun param1 80 0 0 modNum)
				else
					(super doVerb: param1)
				)
			)
			(6
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(= global178 7) ; PLAY-008: bit 6 marks topics aRameses has answered
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
								(if (proc27_0 6 global364)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 72 0 0 modNum)
									(proc27_1 6 @global364)
								)
							)
							((proc27_0 6 global297)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 3 0 0 modNum)
								(proc27_1 6 @global297)
							)
						)
					)
					(259
						(cond
							((or (IsFlag 171) (IsFlag 12))
								(if (proc27_0 6 global363)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 69 0 0 modNum)
									(proc27_1 6 @global363)
								)
							)
							((proc27_0 6 global298)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 4 0 0 modNum)
								(proc27_1 6 @global298)
							)
						)
					)
					(266
						(cond
							((or (IsFlag 161) (IsFlag 68))
								(if (proc27_0 6 global367)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 73 0 0 modNum)
									(proc27_1 6 @global367)
								)
							)
							((proc27_0 6 global305)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 11 0 0 modNum)
								(proc27_1 6 @global305)
							)
						)
					)
					(267
						(cond
							((or (IsFlag 158) (IsFlag 67))
								(if (proc27_0 6 global365)
									(gMessager say: noun 6 1 0 0 modNum)
								else
									(gMessager say: noun 6 71 0 0 modNum)
									(proc27_1 6 @global365)
								)
							)
							((proc27_0 6 global306)
								(gMessager say: noun 6 1 0 0 modNum)
							)
							(else
								(gMessager say: noun 6 12 0 0 modNum)
								(proc27_1 6 @global306)
							)
						)
					)
					(else
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
				)
			)
			(else
				(super doVerb: param1)
			)
		)
	)
)
